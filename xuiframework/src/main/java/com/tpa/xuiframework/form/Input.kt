package com.tpa.xuiframework.form

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Input(val prop: String = "test") {
}