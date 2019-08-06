package com.tpa.xuiframework.adapter

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tpa.xuiframework.viewholder.XViewHolder

class PaginationAdapter<T>(
    @LayoutRes resId: Int,
    @LayoutRes val progressLayout: Int,
    list: ArrayList<T> = arrayListOf<T>(),
    val recyclerView: RecyclerView,
    renderer: ((View, T) -> Unit)? = null
) :
    XAdapterBinding<T>(resId, list, renderer) {

    val VIEWTYPE_LOADING = 1
    val VIEWTYPE_CONTENT = 2

    var loading = false

    override fun onBindViewHolder(viewHolder: XViewHolder<T>, index: Int) {
        if (getItemViewType(index) == 1){

        } else {
            super.onBindViewHolder(viewHolder, index)

            if (index == itemCount - 1) {
                println("end list")
                loading = true
                recyclerView.post {
                    notifyItemInserted(itemCount + 1)
                }
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (loading && position == itemCount - 1){
            VIEWTYPE_LOADING
        } else {
            VIEWTYPE_CONTENT
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): XViewHolder<T> {
        if (i == VIEWTYPE_LOADING){
            return XViewHolder(LayoutInflater.from(parent.context)
                .inflate(progressLayout, parent, false))
        } else if (i == VIEWTYPE_CONTENT) {
            return super.onCreateViewHolder(parent, i)
        }
        throw IllegalStateException()
    }

    override fun getItemCount(): Int {
        return if (loading) {
            super.getItemCount() + 1
        } else {
            super.getItemCount()
        }
    }
}