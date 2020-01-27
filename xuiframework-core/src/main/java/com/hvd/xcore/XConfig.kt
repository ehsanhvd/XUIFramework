package com.hvd.xcore

import android.app.Application
import android.graphics.Typeface

class XConfig {
    companion object {
        var logTag: String = "XUIFramworkLogger"
        var logEnabled: Boolean = true

        var baseUrl: String = ""

        var app: Application? = null
        val typefaces = arrayListOf<Typeface>()
    }
}