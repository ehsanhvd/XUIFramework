package com.tpa.xuiframework.form.validator

import android.widget.EditText
import com.hvd.xcore.XUtil
import com.tpa.xuiframework.form.Validator

class IranNationalCodeValidator: Validator {
    override fun isValid(editText: EditText): Boolean {
        return XUtil.isIranNationalIdValid(editText.text.toString())
    }
}