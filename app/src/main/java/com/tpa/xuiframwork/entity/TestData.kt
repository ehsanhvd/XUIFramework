package com.tpa.xuiframwork.entity

class TestData(name: String, val profile: String) {

    val name: String = name

    constructor(name: String) : this(name, "") {

    }
}