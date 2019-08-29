package com.tpa.xuiframework.webservice

import com.tpa.xuiframework.XConfig
import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import org.json.JSONObject
import java.io.IOException


fun xRequest(serviceName: String, block: XRequest.() -> Unit): XRequest {
    val xRequest = XRequest(serviceName)
    block(xRequest)
    return xRequest
}


data class XRequest(
    val serviceName: String,
    var type: Type = Type.TYPE_GET,
    val params: ArrayList<Param> = arrayListOf()
) {

    companion object {
        val client = OkHttpClient()
    }

    operator fun Param.unaryPlus() {
        addParam(this)
    }

    fun addParam(param: Param): XRequest {
        params.add(param)
        return this;
    }

    public fun start(
        response: (json: JSONObject) -> Any,
        error: (e: IOException) -> Any = {}
    ) {

        var url = XConfig.baseUrl.toHttpUrlOrNull()?.newBuilder()
            ?.addEncodedPathSegment(serviceName + XConfig.serviceNamePostfix)

        if (type == Type.TYPE_GET) {
            params.forEach {
                url?.addQueryParameter(it.name, it.value)
            }
        }

        url?.build()?.let {
            val request = Request.Builder()
                .url(it)

            if (type == Type.TYPE_POST) {
                //TODO
            }

            println(it)

            client.newCall(request.build()).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    error(e)
                }

                override fun onResponse(call: Call, response: Response) {
                    response(JSONObject(response.body?.string()))
                }
            })
        }
    }

    enum class Type {
        TYPE_GET,
        TYPE_POST
    }
}

infix fun String.iz(value: String): Param {
    return Param(this, value)
}

infix fun String.iz(value: Int): Param {
    return Param(this, value)
}

infix fun String.iz(value: Long): Param {
    return Param(this, value)
}

infix fun String.iz(value: Float): Param {
    return Param(this, value)
}

infix fun String.iz(value: Double): Param {
    return Param(this, value)
}

infix fun String.iz(value: Boolean): Param {
    return Param(this, value)
}