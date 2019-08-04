package com.tpa.xuiframwork.entity

data class TestData(val name: String, val profile: String) {
    constructor(name: String) : this(name, "") {

    }
}