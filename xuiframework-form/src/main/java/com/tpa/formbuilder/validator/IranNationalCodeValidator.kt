package com.tpa.formbuilder.validator

import android.widget.EditText
import com.hvd.xcore.XUtil
import com.tpa.formbuilder.Validator

class IranNationalCodeValidator: Validator {
    override fun isValid(editText: EditText): Boolean {
        return XUtil.isIranNationalIdValid(editText.text.toString())
    }
}