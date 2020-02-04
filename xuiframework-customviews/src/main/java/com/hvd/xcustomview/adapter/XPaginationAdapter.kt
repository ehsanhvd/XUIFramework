package com.hvd.xcustomview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.hvd.xcustomview.viewholder.XViewHolder
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext

open class XPaginationAdapter<T>(
    @LayoutRes val progressLayout: Int? = null,
    val recyclerView: RecyclerView,
    val endListReached: ((XPaginationAdapter<T>, Int) -> Unit)? = null,
    var renderer: ((View, T, Int) -> Unit)? = null
) : RecyclerView.Adapter<XViewHolder<T>>() {

    constructor(
        @LayoutRes resId: Int,
        @LayoutRes progressLayout: Int? = null,
        recyclerView: RecyclerView,
        endListReached: ((XPaginationAdapter<T>, Int) -> Unit)? = null,
        renderer: ((View, T, Int) -> Unit)? = null
    ) : this(progressLayout, recyclerView, endListReached, renderer) {
        this.resId = resId
    }

    constructor(
        viewComponent: AnkoComponent<ViewGroup>,
        @LayoutRes progressLayout: Int? = null,
        recyclerView: RecyclerView,
        endListReached: ((XPaginationAdapter<T>, Int) -> Unit)? = null,
        renderer: ((View, T, Int) -> Unit)? = null
    ) : this(progressLayout, recyclerView, endListReached, renderer) {
        this.viewComponent = viewComponent;
    }

    var viewComponent: AnkoComponent<ViewGroup>? = null
    var resId: Int? = null

    val list: ArrayList<T> = arrayListOf()
    val VIEWTYPE_LOADING = 1
    val VIEWTYPE_CONTENT = 2

    var listFinished = false
    var loading = false
        set(value) {
            field = value
            if (loading) {
                recyclerView.post {
                    notifyItemInserted(itemCount + 1)
                }
            } else {
                notifyItemRemoved(itemCount)
            }
        }

    override fun onBindViewHolder(viewHolder: XViewHolder<T>, index: Int) {
        if (getItemViewType(index) == VIEWTYPE_CONTENT) {
            viewHolder.bind(getItem(index)) { view: View, t: T, i: Int ->
                renderer?.invoke(view, t, i)
            }

            if (index == itemCount - 1 && progressLayout != null && !listFinished) {
                println("end list")
                endListReached?.let { it(this, itemCount) }
                loading = true
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (loading && position == itemCount - 1 && progressLayout != null && !listFinished) {
            VIEWTYPE_LOADING
        } else {
            VIEWTYPE_CONTENT
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): XViewHolder<T> {
        if (i == VIEWTYPE_LOADING) {
            return XViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(progressLayout!!, parent, false)
            )
        } else if (i == VIEWTYPE_CONTENT) {
            if (viewComponent != null){
                return XViewHolder(
                    viewComponent!!.createView(
                        AnkoContext.create(recyclerView.context, parent)
                    )
                )
            } else if (resId != null) {
                return XViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        resId!!,
                        parent,
                        false
                    )
                )
            } else {
                throw IllegalStateException("set resourceId or anko component")
            }
        }
        throw IllegalStateException()
    }

    override fun getItemCount(): Int {
        return if (loading) {
            list.size + 1
        } else {
            list.size
        }
    }

    open fun addItems(items: List<T>) {
        loading = false
        val oldSize = itemCount;
        list.addAll(items)
        notifyItemRangeInserted(oldSize, itemCount)
    }

    open fun addItem(item: T) {
        loading = false
        val oldSize = itemCount;
        list.add(item)
        notifyItemRangeInserted(oldSize, itemCount)
    }

    fun getItem(i: Int): T {
        return list.get(i)
    }

    @JvmName("changeRenderer")
    fun setRenderer (renderer: ((View, T, Int) -> Unit)){
        this.renderer = renderer
    }


}