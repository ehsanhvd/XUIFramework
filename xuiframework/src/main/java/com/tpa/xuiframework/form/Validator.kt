package com.tpa.xuiframework.form

import android.widget.EditText

interface Validator {
    fun isValid(editText: EditText): Boolean
}