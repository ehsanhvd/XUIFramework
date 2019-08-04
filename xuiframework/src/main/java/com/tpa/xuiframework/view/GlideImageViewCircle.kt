package com.tpa.xuiframework.view

import android.content.Context
import android.util.AttributeSet
import com.bumptech.glide.request.RequestOptions

class GlideImageViewCircle(context: Context, attrs: AttributeSet?, defStyleAttr: Int): GlideImageView(context, attrs, defStyleAttr) {


    constructor(context: Context) : this(context, null, 0)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)


    protected override fun getOptions(): RequestOptions? {
        return super.getOptions()?.apply(RequestOptions.circleCropTransform())
    }

}