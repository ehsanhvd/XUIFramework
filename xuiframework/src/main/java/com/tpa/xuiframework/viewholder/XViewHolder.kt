package com.tpa.xuiframework.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View

open class XViewHolder<T>(val view: View) : RecyclerView.ViewHolder(view) {

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

    protected open fun render(itemView: View, item: T) {

    }
}