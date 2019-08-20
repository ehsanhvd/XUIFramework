package com.tpa.xuiframework

import android.util.Log
import com.tpa.xuiframework.extention.ifT

fun log(any: Any) {
    XConfig.logEnabled.ifT {
        Log.d(XConfig.logTag, any.toString())
    }
}