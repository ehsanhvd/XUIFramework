package com.tpa.xuiframework.extention

import android.view.View
import android.widget.TextView

fun View.setText(id: Int, text: String){
    findViewById<TextView>(id).setText(text)
}