package com.tpa.xuiframework.form.annotation

import android.view.inputmethod.EditorInfo

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class IranTelInput(
    val displayName: String = "",
    val text: String = "",
    val imeOpt: Int = EditorInfo.IME_ACTION_NEXT,
    val lastRow: Boolean = false
)