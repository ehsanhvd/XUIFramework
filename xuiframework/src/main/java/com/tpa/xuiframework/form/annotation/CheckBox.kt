package com.tpa.xuiframework.form.annotation

import android.view.View

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class CheckBox(
    val displayName: String = "",
    val id: Int = View.NO_ID
)