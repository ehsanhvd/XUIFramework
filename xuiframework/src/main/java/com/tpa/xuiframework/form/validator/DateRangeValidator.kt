package com.tpa.xuiframework.form.validator

import android.widget.EditText
import com.tpa.xuiframework.form.Validator
import com.tpa.xuiframework.view.BaseDatePickerTextView


class DateRangeValidator(val min: Long = -1, val max: Long = -1) : Validator {
    override fun isValid(editText: EditText): Boolean {
        val datePickerTextView = editText as BaseDatePickerTextView

        return datePickerTextView.time in (min + 1) until max
    }
}