package com.tpa.xuiframework

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View

class XViewHolder<T>(val viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {

    var item: T? = null
    var renderer: ((View, T) -> Unit)? = null

    init {

    }

    public fun bind(item: T, renderer: ((View, T) -> Unit)?) {
        this.item = item
        this.renderer = renderer

        render(itemView, item)
        renderer?.invoke(itemView, item)
    }

    protected fun render(itemView: View, item: T) {
        viewDataBinding.setVariable(1, item)
        viewDataBinding.executePendingBindings()
    }
}