package com.tpa.xuiframework

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.R
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class XAdapter<T>(
    val res: Int,
    val list: ArrayList<T> = arrayListOf<T>(),
    val renderer: ((View, T) -> Unit)? = null
                  ): RecyclerView.Adapter<XViewHolder<T>>() {

//    constructor(res: Int) : this(res, ){
//
//    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): XViewHolder<T> {

        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), res, parent, false)
//        return XViewHolder(LayoutInflater.from(parent.context).inflate(res, parent, false))
        return XViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size;
    }

    override fun onBindViewHolder(viewHolder: XViewHolder<T>, index: Int) {
        viewHolder.bind(getItem(index), renderer)
    }

    public fun getItem(i: Int): T{
        return list.get(i)
    }
}