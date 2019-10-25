package com.tpa.xuiframework.form

import android.widget.EditText

class RangeValidator(val min: Long, val max: Long) : Validator {
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