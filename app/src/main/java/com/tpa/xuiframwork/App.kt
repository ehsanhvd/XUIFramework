package com.tpa.xuiframwork

import androidx.multidex.MultiDexApplication
import com.hvd.xcore.XConfig
import com.hvd.xcore.XUtil

class App : MultiDexApplication() {

    companion object {
        lateinit var app: App
    }

    override fun onCreate() {
        super.onCreate()

        app = this
        XConfig.app = this
        XConfig.logTag = "xuiSample"

        XConfig.typefaces.add(XUtil.getTypeface("font/Vazir.ttf"))
        XConfig.typefaces.add(XUtil.getTypeface("font/Vazir-Light.ttf"))
        XConfig.typefaces.add(XUtil.getTypeface("font/Vazir-Bold.ttf"))

        XConfig.baseUrl = "http://localhost/travelo/ws"
    }
}