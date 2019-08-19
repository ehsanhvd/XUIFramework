package com.tpa.xuiframwork

import android.app.Application
import com.tpa.xuiframework.XConfig
import com.tpa.xuiframework.XUtil

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        XConfig.app = this
        XConfig.logTag = "xuiSample"

        XConfig.typefaces.add(XUtil.getTypeface("font/Vazir.ttf"))
        XConfig.typefaces.add(XUtil.getTypeface("font/Vazir-Light.ttf"))
        XConfig.typefaces.add(XUtil.getTypeface("font/Vazir-Bold.ttf"))

        XConfig.baseUrl = "http://localhost/travelo/ws"
        XConfig.serviceNamePostfix = ".php"
    }
}