package com.tpa.xuiframework.form.annotation

import android.view.inputmethod.EditorInfo

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class CheckBox(
    val displayName: String = ""
)