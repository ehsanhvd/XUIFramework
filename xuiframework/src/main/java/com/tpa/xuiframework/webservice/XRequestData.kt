package com.tpa.xuiframework.webservice

import com.google.gson.Gson
import com.tpa.xuiframework.XConfig
import org.json.JSONObject
import java.io.IOException


class XRequestData<T>(absUrl: String) : XRequest(absUrl) {

    fun startData(
        clazz: Class<T>,
        response: (resObj: T) -> Any,
        error: (e: IOException) -> Any = {}
    ) {

        start({
            val responseObj: T = Gson().fromJson(it, clazz)

            response(responseObj)
        }, {
            error(it)
        })

    }

    fun startDeserializer(
        clazz: Class<T>,
        response: (json: JSONObject) -> Any,
        error: (e: IOException) -> Any = {}
    ) {

        start({

            response(JSONObject(it))
        }, {
            error(it)
        })

    }
}


fun <T> xRequestDataAbs(absAddress: String): XRequestData<T> {
    return XRequestData(absAddress)
}

fun <T> xRequestData(serviceName: String): XRequestData<T> {
    return xRequestDataAbs(XConfig.baseUrl + serviceName)
}