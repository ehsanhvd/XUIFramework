package com.tpa.formbuilder.validator

import android.widget.EditText
import com.tpa.formbuilder.Validator

class DefaultValidator : Validator {
    override fun isValid(editText: EditText): Boolean {
        return true
    }
}