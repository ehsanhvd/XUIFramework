package com.hvd.xcore.webservice

import android.os.Handler
import android.os.Looper
import com.hvd.xcore.NNE
import com.hvd.xcore.XConfig
import com.hvd.xcore.log
import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import org.json.JSONObject
import java.io.IOException

open class XRequest(private val absUrl: String) {

    private var urlRequest: HttpUrl.Builder =
        absUrl.toHttpUrlOrNull()?.newBuilder()!!.addEncodedPathSegment(absUrl)

    private var body: FormBody.Builder? = null

    companion object {
        var client: OkHttpClient? = null
    }

    init {
        if (client == null){
            client = OkHttpClient.Builder().addInterceptor {
                val request = it.request()
                log("request: " + request.url)
                NNE(request.body.toString()) {
                    log("request body: $it")
                }
                it.proceed(request)
            }.build()
        }
    }

    fun qParam(name: String, value: String): XRequest {
        urlRequest.addQueryParameter(name, value)
        return this
    }

    fun bodyParam(name: String, value: String) {
        if (body == null){
            body= FormBody.Builder()
        }
        body?.add(name, value)
    }

    fun startRaw(
        response: (resString: String) -> Any,
        error: (e: IOException) -> Any = {}
    ) {
        val request = Request.Builder()
            .url(urlRequest.build())

        if (body != null){
            request.post(body!!.build())
        }

        client!!.newCall(request.build()).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                Handler(Looper.getMainLooper()).post {
                    error(e)
                }
            }

            override fun onResponse(call: Call, response: Response) {
                val responseString = response.body?.string()!!
                log("server responded $responseString")
                Handler(Looper.getMainLooper()).post {
                    response(responseString)
                }

            }
        })
    }

    fun startDeserializer(
        response: (json: JSONObject) -> Any,
        error: (e: IOException) -> Any = {}
    ) {

        startRaw({
            response(JSONObject(it))
        }, {
            error(it)
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