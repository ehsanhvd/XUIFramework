package com.tpa.xuiframwork.entity

import com.tpa.xuiframework.form.Input

class TestData(name: String, val profile: String) {

    @Input("done!")
    val name: String = name

    constructor(name: String) : this(name, "") {

    }
}