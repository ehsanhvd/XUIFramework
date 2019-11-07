package com.tpa.xuiframework.form.annotation

import android.view.inputmethod.EditorInfo

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class EmailInput(
    val displayName: String = "",
    val imeOpt: Int = EditorInfo.IME_ACTION_NEXT,
    val mandatory: Boolean = false,
    val id: Int = 0
)