package com.tpa.xuiframework.form.validator

import android.widget.EditText
import com.tpa.xuiframework.form.Validator

class MandatoryValidator : Validator {
    override fun isValid(editText: EditText): Boolean {
        return !editText.text.toString().isEmpty()
    }
}