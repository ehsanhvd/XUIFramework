package com.tpa.xuiframework.webservice

import android.os.Handler
import android.os.Looper
import com.tpa.xuiframework.XConfig
import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import java.io.IOException
import javax.net.ssl.SSLContext


open class XRequest(private val absUrl: String) {

    var urlRequest: HttpUrl.Builder =
        absUrl.toHttpUrlOrNull()?.newBuilder()!!.addEncodedPathSegment(absUrl)

    companion object {
        var client: OkHttpClient? = null
    }

    init {
        client = OkHttpClient()
        var sslContext = SSLContext.getInstance("SSL")
    }

    fun qParam(name: String, value: String) {
        urlRequest.addQueryParameter(name, value)
    }

    fun start(
        response: (resString: String) -> Any,
        error: (e: IOException) -> Any = {}
    ) {
        val request = Request.Builder()
            .url(urlRequest.build())

        client!!.newCall(request.build()).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Handler(Looper.getMainLooper()).post {
                    error(e)
                }
            }

            override fun onResponse(call: Call, response: Response) {
                Handler(Looper.getMainLooper()).post {
                    response(response.body?.string()!!)
                }

            }
        })
    }

    fun getUrl(): String {
        return absUrl
    }
}


fun xRequestAbs(absAddress: String): XRequest {
    return XRequest(absAddress)
}

fun xRequest(serviceName: String): XRequest {
    return xRequestAbs(XConfig.baseUrl + serviceName)
}