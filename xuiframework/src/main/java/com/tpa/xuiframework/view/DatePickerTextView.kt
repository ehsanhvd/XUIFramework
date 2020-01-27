package com.tpa.xuiframework.view

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.AttributeSet
import androidx.appcompat.app.AppCompatActivity
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar
import com.mohamadamin.persianmaterialdatetimepicker.utils.getFormatedPersianDate
import com.tpa.xuiframework.utils.XDatePicker


class DatePickerTextView : BaseDatePickerTextView {

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
            XDatePicker(getActivity() as AppCompatActivity).showDatePicker { datePickerDialog: DatePickerDialog, day: Int, month: Int, year: Int ->
                val calendar = PersianCalendar()
                calendar.setPersianDate(day, month, year)
                setText(calendar.getFormatedPersianDate(format))

                val persianCalendar = PersianCalendar()
                persianCalendar.setPersianDate(year, month, day)
                time = persianCalendar.timeInMillis

                setError(null)
            }
        }
    }
}