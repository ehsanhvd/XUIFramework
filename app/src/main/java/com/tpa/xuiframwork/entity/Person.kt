package com.tpa.xuiframwork.entity

import com.tpa.xuiframework.form.annotation.Input
import com.tpa.xuiframework.form.annotation.IranTelInput

data class Person(
    @Input(displayName = "name and family hint")
    var name: String,

    @IranTelInput
    var tel: String = ""
    ) {
}