package com.tpa.xuiframwork

import android.app.Application
import com.tpa.xuiframework.webservice.XRequest

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        XRequest.baseUrl = "http://localhost/travelo/ws"
        XRequest.serviceNamePostfix = ".php"
    }
}