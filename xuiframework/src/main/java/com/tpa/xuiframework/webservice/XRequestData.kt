package com.tpa.xuiframework.webservice

import com.google.gson.Gson
import com.tpa.xuiframework.XConfig
import java.io.IOException


class XRequestData(absUrl: String) : XRequest(absUrl) {

    inline fun <reified T> startData(
        crossinline response: (resObj: T) -> Any,
        crossinline error: (e: IOException) -> Any = {}
    ) {

        startRaw({
            val responseObj: T = Gson().fromJson(it, T::class.java)

            response(responseObj)
        }, {
            error(it)
        })

    }
}


fun xRequestDataAbs(absAddress: String): XRequestData {
    return XRequestData(absAddress)
}

fun xRequestData(serviceName: String): XRequestData {
    return xRequestDataAbs(XConfig.baseUrl + serviceName)
}