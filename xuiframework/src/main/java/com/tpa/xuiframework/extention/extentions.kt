package com.tpa.xuiframework.extention

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.TextView
import com.tpa.xuiframework.view.GlideImageView

fun View.setText(id: Int, text: String) {
    findViewById<TextView>(id).setText(text)
}

fun View.loadImage(id: Int, url: String) {
    findViewById<GlideImageView>(id).loadUrl(url)
}

fun Fragment.addParam(name: String, value: String) {
    var arguments = arguments;
    if (arguments == null) {
        arguments = Bundle()
    }

    arguments.putString(name, value)
    this.arguments = arguments
}

fun Boolean.ifT(op: () -> Any) {
    if (this) {
        op()
    }
}