package com.tpa.xuiframework.form.validator

import android.widget.EditText
import com.tpa.xuiframework.form.Validator

class DefaultValidator : Validator {
    override fun isValid(editText: EditText): Boolean {
        return true
    }
}