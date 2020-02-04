package com.tpa.formbuilder

import android.widget.EditText

interface Validator {
    fun isValid(editText: EditText): Boolean
}