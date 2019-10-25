package com.tpa.xuiframework.adapter

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.AnkoComponent

class XMultiSelectAdapter<T> : XPaginationAdapter<T> {

    private var selectionRenderer: ((View, T, Int, Boolean) -> Unit)? = null
    private var selections = arrayListOf<Boolean>()
    private var selectionCount = 0

    constructor(
        @LayoutRes resId: Int,
        @LayoutRes progressLayout: Int? = null,
        recyclerView: RecyclerView,
        endListReached: ((XPaginationAdapter<T>, Int) -> Unit)? = null,
        renderer: ((View, T, Int, Boolean) -> Unit)? = null
    ) : super(
        progressLayout, recyclerView, endListReached,
        null
    ) {
        this.resId = resId
        selectionRenderer = renderer
    }

    constructor(
        viewComponent: AnkoComponent<ViewGroup>,
        @LayoutRes progressLayout: Int? = null,
        recyclerView: RecyclerView,
        endListReached: ((XPaginationAdapter<T>, Int) -> Unit)? = null,
        renderer: ((View, T, Int, Boolean) -> Unit)? = null
    ) : super(progressLayout, recyclerView, endListReached, null) {
        this.viewComponent = viewComponent
        selectionRenderer = renderer
    }

    init {
        setRenderer { view: View, t: T, i: Int ->
            selectionRenderer?.invoke(view, t, i, selections[i])
        }
    }

    override fun addItems(items: List<T>) {
        super.addItems(items)
        selections.addAll(BooleanArray(items.size).toTypedArray())
    }

    override fun addItem(item: T) {
        super.addItem(item)
        selections.add(false)
    }

    fun setSelection(index: Int, selection: Boolean) {
        selections[index] = selection
        notifyItemChanged(index)
        if (selection) {
            selectionCount++
        } else {
            selectionCount--
        }
    }

    fun getSelection(index: Int): Boolean {
        return selections[index]
    }

    fun invertSelection(index: Int) {
        setSelection(index, !getSelection(index))
    }

    fun unSelectAll() {
        for (i in 0 until selections.size) {
            selections[i] = false
        }
        selectionCount = 0
        notifyDataSetChanged()
    }

    fun getSelectionCount(): Int {
        return selectionCount
    }
}