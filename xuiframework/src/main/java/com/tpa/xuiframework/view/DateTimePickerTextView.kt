package com.tpa.xuiframework.view

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.AttributeSet
import androidx.appcompat.app.AppCompatActivity
import com.mohamadamin.persianmaterialdatetimepicker.time.TimePickerDialog
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar
import com.tpa.xuiframework.utils.XDateTimePicker
import com.tpa.xuiframework.utils.XUtil

class DateTimePickerTextView : BaseDatePickerTextView {
    constructor(context: Context) : super(context)

    constructor(context: Context, format: Int) : super(context, format)

    constructor(context: Context, attrs : AttributeSet) : super(context,attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr : Int) : super(context, attrs, defStyleAttr)

    private fun getActivity(): Activity? {
        var context = context
        while (context is ContextWrapper) {
            if (context is Activity) {
                return context
            }
            context = context.baseContext
        }
        return null
    }

    init {
        setOnClickListener {
            XDateTimePicker(getActivity() as AppCompatActivity).showDateTimePicker { timePickerDialog: TimePickerDialog, day: Int, month: Int, year: Int, hour: Int, min: Int ->
                setText(XUtil.getPersianDateTime(format, day, month, year, hour, min))

                val persianCalendar = PersianCalendar()
                persianCalendar.setPersianDate(year, month, day)
                time = persianCalendar.timeInMillis

                setError(null)
            }
        }
    }
}