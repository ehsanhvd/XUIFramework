package com.tpa.xuiframework.form.validator

import android.widget.EditText
import com.tpa.xuiframework.form.Validator

class RangeValidator(val min: Long = -1, val max: Long = -1) : Validator {
    override fun isValid(editText: EditText): Boolean {
        val valString = editText.text.toString()
        val numVal = valString.toLongOrNull();

        if (numVal == null){
            return false
        } else {
            return min < numVal && numVal < max
        }

    }
}