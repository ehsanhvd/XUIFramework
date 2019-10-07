package com.tpa.xuiframwork

import android.app.Application
import com.tpa.xuiframework.XConfig
import com.tpa.xuiframework.utils.XUtil

class App : Application() {

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
        XConfig.serviceNamePostfix = ".php"
    }
}