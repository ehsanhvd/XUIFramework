package com.hvd.xcore.webservice

data class Param(val name: String, val value: String) {
    constructor(name: String, value: Int): this (name, value.toString())
    constructor(name: String, value: Long): this (name, value.toString())
    constructor(name: String, value: Float): this (name, value.toString())
    constructor(name: String, value: Double): this (name, value.toString())
    constructor(name: String, value: Boolean): this (name, value.toString())
}