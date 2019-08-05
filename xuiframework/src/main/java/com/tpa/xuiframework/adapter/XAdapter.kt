package com.tpa.xuiframework.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tpa.xuiframework.viewholder.XViewHolder


open class XAdapter<T>(
    val res: Int,
    val list: ArrayList<T> = arrayListOf(),
    val renderer: ((View, T) -> Unit)? = null
) : RecyclerView.Adapter<XViewHolder<T>>() {


//    constructor(res: Int, renderer: (View, T) -> Unit) : this(res, renderer = renderer) {
//        add(request)
//    }

//    public fun add(request: XReq){
//        url = HttpUrl.Builder()
//            .scheme("http")
//            .host("localhost")
//            .addPathSegment("travelo")
//            .addPathSegment("ws")
//            .addPathSegment(request.serviceName + XConfig.serviceNamePostFix)
//
//        request.params.forEach {
//            url?.addQueryParameter(it.name, it.value)
//        }
//
//        println(url.toString())
//    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): XViewHolder<T> {
        return XViewHolder(LayoutInflater.from(parent.context).inflate(res, parent, false))
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