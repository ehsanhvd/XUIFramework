package com.tpa.xuiframwork.entity

class TestData(name: String, val profile: String) {

    val name: String = name

    constructor(name: String) : this(name, "") {

    }

    enum class TYPE(val DISPLAY_NAME: String,val VALUE: Int) {
        TYPE1("dispname1", 1),
        TYPE2("dispname2", 2);

        override fun toString(): String {
            return this.name
        }
    }
}