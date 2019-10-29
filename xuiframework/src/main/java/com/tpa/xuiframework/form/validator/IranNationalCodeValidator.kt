package com.tpa.xuiframework.form.validator

import android.widget.EditText
import com.tpa.xuiframework.form.Validator
import com.tpa.xuiframework.utils.XUtil

class IranNationalCodeValidator: Validator {
    override fun isValid(editText: EditText): Boolean {
        return XUtil.isIranNationalIdValid(editText.text.toString())
    }
}