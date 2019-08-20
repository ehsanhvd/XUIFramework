package com.tpa.xuiframework

import android.app.Application
import android.graphics.Typeface

class XConfig {
    companion object {
        var logTag: String = "XUIFramworkLogger"
        var logEnabled: Boolean = true

        var baseUrl: String = ""
        var serviceNamePostfix: String = ""

        lateinit var app: Application
        val typefaces = arrayListOf<Typeface>()
    }
}