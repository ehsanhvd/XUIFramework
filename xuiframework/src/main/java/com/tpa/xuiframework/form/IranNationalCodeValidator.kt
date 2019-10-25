package com.tpa.xuiframework.form

import android.widget.EditText
import com.tpa.xuiframework.utils.XUtil

class IranNationalCodeValidator: Validator {
    override fun isValid(editText: EditText): Boolean {
        return XUtil.isIranNationalIdValid(editText.text.toString())
    }
}