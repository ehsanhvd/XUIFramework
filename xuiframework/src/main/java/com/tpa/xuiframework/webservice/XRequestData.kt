package com.tpa.xuiframework.webservice

import com.google.gson.Gson
import com.tpa.xuiframework.XConfig
import java.io.IOException


class XRequestData<T>(absUrl: String) : XRequest(absUrl) {

    init {


//        type = (javaClass.getGenericSuperclass() as ParameterizedType).getActualTypeArguments()[0] as Class<T>?
    }

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
}


fun <T> xRequestDataAbs(absAddress: String): XRequestData<T> {
    return XRequestData(absAddress)
}

fun <T> xRequestData(serviceName: String): XRequestData<T> {
    return xRequestDataAbs(XConfig.baseUrl + serviceName)
}