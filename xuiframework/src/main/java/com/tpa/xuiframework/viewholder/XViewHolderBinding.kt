package com.tpa.xuiframework.viewholder

import android.databinding.ViewDataBinding
import android.view.View

class XViewHolderBinding<T>(val viewDataBinding: ViewDataBinding) : XViewHolder<T>(viewDataBinding.root) {

    protected override fun render(itemView: View, item: T) {
        viewDataBinding.setVariable(1, item)
        viewDataBinding.executePendingBindings()
    }
}