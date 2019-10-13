package com.tpa.xuiframework.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.tpa.xuiframework.viewholder.XViewHolder
import com.tpa.xuiframework.viewholder.XViewHolderBinding

open class XAdapterBinding<T>(
    res: Int,
    list: ArrayList<T> = arrayListOf<T>(),
    renderer: ((View, T) -> Unit)? = null
) : XAdapter<T>(res, list, renderer) {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): XViewHolder<T> {

        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), res, parent, false)
        return XViewHolderBinding(binding)
    }


}