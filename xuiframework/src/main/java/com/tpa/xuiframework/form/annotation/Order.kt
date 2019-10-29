package com.tpa.xuiframework.form.annotation

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Order(val order: Int) {
}