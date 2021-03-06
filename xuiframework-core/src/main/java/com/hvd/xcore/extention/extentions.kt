package com.hvd.xcore.extention

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.hvd.xcore.XUtil
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext

fun ViewGroup.addView(ctext: Context, view: AnkoComponent<ViewGroup>){
    this.addView(view.createView(AnkoContext.create(ctext, this)))
}

fun View.setText(id: Int, text: String) {
    findViewById<TextView>(id).setText(text)
}

fun Fragment.addParam(name: String, value: String) {
    var arguments = arguments;
    if (arguments == null) {
        arguments = Bundle()
    }

    arguments.putString(name, value)
    this.arguments = arguments
}

fun Boolean.ifT(op: () -> Unit) {
    if (this) {
        op()
    }
}

fun Boolean.ifNT(op: () -> Unit) {
    if (this) {
        op()
    }
}

fun String.ifNotEmpty(op: () -> Any?) {
    if (!this.isEmpty()) {
        op()
    }
}

fun Activity.getActivityLabel(): String? {
    try {
        val stringRes = this.packageManager.getActivityInfo(this.componentName, 0).labelRes
        if (stringRes != 0) {
            return this.resources.getString(stringRes)
        }
    } catch (var2: PackageManager.NameNotFoundException) {
        var2.printStackTrace()
    }

    return null
}

fun Activity.showSnackbar(text: String) {
    XUtil.showSnackbar(this.findViewById(android.R.id.content), text)
}

fun Fragment.showSnackbar(text: String) {
    XUtil.showSnackbar(view!!, text)
}
