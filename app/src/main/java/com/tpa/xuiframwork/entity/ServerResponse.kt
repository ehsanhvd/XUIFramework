package com.tpa.xuiframwork.entity

import com.google.gson.annotations.SerializedName

data class ServerResponse(
    var date: String,

    @SerializedName("milliseconds_since_epoch")
    var milis: Long,

    var time: String
) {
}