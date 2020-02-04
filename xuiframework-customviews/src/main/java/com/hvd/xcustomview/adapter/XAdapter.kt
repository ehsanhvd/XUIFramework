package com.hvd.xcustomview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hvd.xcustomview.viewholder.XViewHolder


open class XAdapter<T>(
    val res: Int,
    val list: ArrayList<T> = arrayListOf(),
    val renderer: ((View, T, Int) -> Unit)? = null
) : RecyclerView.Adapter<XViewHolder<T>>() {


    override fun onCreateViewHolder(parent: ViewGroup, i: Int): XViewHolder<T> {
        return XViewHolder(
            LayoutInflater.from(parent.context).inflate(
                res,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size;
    }

    override fun onBindViewHolder(viewHolderBinding: XViewHolder<T>, index: Int) {
        viewHolderBinding.bind(getItem(index), renderer)
    }

    public fun getItem(i: Int): T {
        return list.get(i)
    }
}