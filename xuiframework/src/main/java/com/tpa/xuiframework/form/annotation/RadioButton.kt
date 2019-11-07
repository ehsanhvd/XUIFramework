package com.tpa.xuiframework.form.annotation

import androidx.annotation.ArrayRes

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class RadioButton(
    val displayName: String,
    @ArrayRes val itemsArray: Int,
    val id: Int = 0
)