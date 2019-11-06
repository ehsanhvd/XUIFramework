package com.tpa.xuiframework.form.annotation

import androidx.annotation.ArrayRes

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Spinner(
    val displayName: String,
    @ArrayRes val itemsArray: Int
)