package com.tpa.xuiframework.extention

import android.view.View
import android.widget.TextView
import com.tpa.xuiframework.view.GlideImageView

fun View.setText(id: Int, text: String){
    findViewById<TextView>(id).setText(text)
}

fun View.loadImage(id: Int, url: String){
    findViewById<GlideImageView>(id).loadUrl(url)
}