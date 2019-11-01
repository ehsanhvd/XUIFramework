package com.tpa.xuiframwork.entity

import com.tpa.xuiframework.form.annotation.*
import com.tpa.xuiframework.form.validator.MandatoryValidator

data class Person(
    @Order(0)
    @Input(displayName = "name and family hint", validator = MandatoryValidator::class)
    var name: String,

    @Order(1)
    @IranTelInput(mandatory = true)
    var tel: String = "",

    @Order(2)
    @DatePicker(displayName = "birthday")
    var birthDay: Long = 0,

    @Order(3)
    @DateTimePicker(displayName = "buyDate")
    var buyDate: Long = 0,

    @Order(4)
    @EmailInput(displayName = "email")
    var email: String = ""
    ) {
}