package com.tpa.xuiframwork.entity

import com.tpa.xuiframework.form.annotation.DatePicker
import com.tpa.xuiframework.form.annotation.Input
import com.tpa.xuiframework.form.annotation.IranTelInput
import com.tpa.xuiframework.form.annotation.Order

data class Person(
    @Order(0)
    @Input(displayName = "name and family hint")
    var name: String,

    @Order(1)
    @IranTelInput
    var tel: String = "",

    @Order(2)
    @DatePicker(displayName = "birthday")
    var birthDay: Long = 0
    ) {
}