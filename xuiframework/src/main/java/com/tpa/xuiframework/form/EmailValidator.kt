package com.tpa.xuiframework.form

import android.widget.EditText
import com.tpa.xuiframework.utils.XUtil

class EmailValidator : Validator {
    override fun isValid(editText: EditText): Boolean {
        return XUtil.isEmailValid(editText.text.toString())
    }
}