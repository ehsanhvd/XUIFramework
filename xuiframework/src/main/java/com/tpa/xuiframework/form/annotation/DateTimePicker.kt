package com.tpa.xuiframework.form.annotation

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class DateTimePicker(
    val displayName: String = "",
    val date: Long = 0
) {
}