package com.tpa.xuiframework.webservice

import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import org.json.JSONObject
import java.io.IOException


class XRequest(val serviceName: String, val type: Type = Type.TYPE_GET, val params: ArrayList<Param> = arrayListOf()) {

    companion object {
        var baseUrl: String = ""
        var serviceNamePostfix: String = ""
        val client = OkHttpClient()
    }

    public fun addParam(name: String, value: Any): XRequest {
        params.add(Param(name, value.toString()))
        return this;
    }

    public fun start(response: (json: JSONObject) -> Any,
                     error: (e: IOException) -> Any) {

        var url = baseUrl.toHttpUrlOrNull()?.newBuilder()?.addEncodedPathSegment(serviceName + serviceNamePostfix)

        if (type == Type.TYPE_GET){
            params.forEach {
                url?.addQueryParameter(it.name, it.value)
            }
        }

        val urlString = url?.build()


        urlString?.let {
            val request = Request.Builder()
                .url(it)

            if (type == Type.TYPE_GET){
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