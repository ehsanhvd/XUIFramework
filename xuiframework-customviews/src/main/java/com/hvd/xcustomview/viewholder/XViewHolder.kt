package com.hvd.xcustomview.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class XViewHolder<T>(val view: View) : RecyclerView.ViewHolder(view) {

    var item: T? = null
    var renderer: ((View, T, Int) -> Unit)? = null

    fun bind(item: T, renderer: ((View, T, Int) -> Unit)?) {
        this.item = item
        this.renderer = renderer

        render(itemView, item)
        renderer?.invoke(itemView, item, adapterPosition)
    }

    protected open fun render(itemView: View, item: T) {

    }
}