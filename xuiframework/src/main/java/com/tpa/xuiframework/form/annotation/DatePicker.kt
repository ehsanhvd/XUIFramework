package com.tpa.xuiframework.form.annotation

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class DatePicker(
    val displayName: String = "",
    val date: Long = 0
) {
}