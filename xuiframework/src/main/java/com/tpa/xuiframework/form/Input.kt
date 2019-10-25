package com.tpa.xuiframework.form

import android.text.InputType

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Input(
    val displayName: String = "",
    val hint: String = "",
    val inputType: Int = InputType.TYPE_CLASS_TEXT
) {
}