package com.tpa.xuiframwork.entity

import com.tpa.xuiframework.form.Input

data class Person(
    @Input(displayName = "name and family hint")
    var name: String) {
}