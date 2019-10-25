package com.tpa.xuiframework.form

import android.widget.EditText
import com.tpa.xuiframework.utils.XUtil

class IranTelValidator : Validator {
    override fun isValid(editText: EditText): Boolean {
        return XUtil.isValidIranTel(editText.text.toString())
    }
}