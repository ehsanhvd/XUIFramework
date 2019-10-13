package com.tpa.xuiframework.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.tpa.xuiframework.viewholder.XViewHolder
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext

class XAdapter2<T>(
    @LayoutRes val progressLayout: Int,
    val recyclerView: RecyclerView,
    val endListReached: ((XAdapter2<T>, Int) -> Unit)? = null,
    val renderer: ((View, T) -> Unit)? = null
) : RecyclerView.Adapter<XViewHolder<T>>() {

    constructor(
        @LayoutRes resId: Int,
        @LayoutRes progressLayout: Int,
        recyclerView: RecyclerView,
        endListReached: ((XAdapter2<T>, Int) -> Unit)? = null,
        renderer: ((View, T) -> Unit)? = null
    ) : this(progressLayout, recyclerView, endListReached, renderer) {
        this.resId = resId
    }

    constructor(
        viewComponent: AnkoComponent<ViewGroup>,
        @LayoutRes progressLayout: Int,
        recyclerView: RecyclerView,
        endListReached: ((XAdapter2<T>, Int) -> Unit)? = null,
        renderer: ((View, T) -> Unit)? = null
    ) : this(progressLayout, recyclerView, endListReached, renderer) {
        this.viewComponent = viewComponent;
    }

    var viewComponent: AnkoComponent<ViewGroup>? = null
    var resId: Int? = null

    val list: ArrayList<T> = arrayListOf()
    val VIEWTYPE_LOADING = 1
    val VIEWTYPE_CONTENT = 2

    public var loading = false
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
        if (getItemViewType(index) == 1) {

        } else {
            viewHolder.bind(getItem(index), renderer)

            if (index == itemCount - 1) {
                println("end list")
                endListReached?.let { it(this, itemCount) }
                loading = true
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (loading && position == itemCount - 1) {
            VIEWTYPE_LOADING
        } else {
            VIEWTYPE_CONTENT
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): XViewHolder<T> {
        if (i == VIEWTYPE_LOADING) {
            return XViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(progressLayout, parent, false)
            )
        } else if (i == VIEWTYPE_CONTENT) {
            if (viewComponent != null){
                return XViewHolder(viewComponent!!.createView(AnkoContext.create(recyclerView.context, parent)))
            } else if (resId != null) {
                return XViewHolder(LayoutInflater.from(parent.context).inflate(resId!!, parent, false))
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

    public fun addItem(items: List<T>) {
        loading = false
        val oldSize = itemCount;
        list.addAll(items)
        notifyItemRangeInserted(oldSize, itemCount)
    }

    public fun getItem(i: Int): T {
        return list.get(i)
    }

}