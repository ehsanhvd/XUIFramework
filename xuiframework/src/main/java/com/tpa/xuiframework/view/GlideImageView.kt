package com.tpa.xuiframework.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.content.res.TypedArray
import android.util.TypedValue
import android.graphics.drawable.ColorDrawable
import android.support.v4.content.ContextCompat
import android.support.v7.content.res.AppCompatResources
import com.tpa.xuiframework.R
import android.view.View.MeasureSpec
import android.support.v7.widget.TintTypedArray.obtainStyledAttributes

open class GlideImageView(context: Context, val attrs: AttributeSet?, val defStyleAttr: Int) :
    ImageView(context, attrs, defStyleAttr) {

    var defDrawable: Drawable? = null

    constructor(context: Context) : this(context, null, 0)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    protected open fun getOptions(): RequestOptions? {
        getPlaceholder()

        val requestOptions = RequestOptions()
        getPlaceholder()?.let { requestOptions.placeholder(it) }
//        requestOptions.placeholder(R.drawable.ic_launcher)
        return requestOptions
    }

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.GlideImageView, defStyleAttr, 0)
        defDrawable = a.getDrawable(R.styleable.GlideImageView_defaultDrawable)
    }

    protected open fun getPlaceholder(): Drawable? {
        return defDrawable
    }

    public fun loadUrl(url: String) {
        val request = Glide.with(getContext())
            .load(url)

        getOptions()?.let { request.apply(it) }

        request.into(this)
    }

    companion object {

        @JvmStatic
        @BindingAdapter("app:url")
        fun setUrl(imageView: GlideImageView, url: String) {
            imageView.loadUrl(url)
        }
    }
}

