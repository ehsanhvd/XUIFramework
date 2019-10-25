package com.tpa.xuiframework.form

import android.text.InputType
import android.view.inputmethod.EditorInfo

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Input(
    val displayName: String = "",
    val inputType: Int = InputType.TYPE_CLASS_TEXT,
    val imeOpt: Int = EditorInfo.IME_ACTION_NEXT,
    val maxLenght: Int = 50
)