package com.tpa.xuiframework.utils

import android.support.v7.app.AppCompatActivity
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog
import java.util.*

open class XDatePicker(
    private val appCompatActivity: AppCompatActivity,
    val calendar: XPersianCalendar = XPersianCalendar()
) {

    private val DATE_FORMAT = "%02d %s %04d"

    //persian
    protected var year: Int = 0
    protected var month: Int = 0
    protected var day: Int = 0

    init {
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        this.year = calendar.persianYear
        this.month = calendar.persianMonth
        this.day = calendar.persianDay
    }

    fun showDatePicker(
        listener: ((datePickerDialog: DatePickerDialog, day: Int, month: Int, year: Int) -> Unit)
    ): XDatePicker {
        buildAndShowDatePicker(listener)
        return this
    }

    fun showDatePicker(
        day: Int,
        month: Int,
        year: Int,
        listener: ((datePickerDialog: DatePickerDialog, day: Int, month: Int, year: Int) -> Unit)
    ): XDatePicker {
        this.year = year
        this.month = month
        this.day = day

        buildAndShowDatePicker(listener)
        return this
    }

    private fun buildAndShowDatePicker(listener: ((datePickerDialog: DatePickerDialog, day: Int, month: Int, year: Int) -> Unit)) {
        val datePickerDialog =
            DatePickerDialog.newInstance({ datePickerDialog: DatePickerDialog, day: Int, month: Int, year: Int ->
                listener(datePickerDialog, day, month, year)
            }, this.year, this.month, this.day)

        datePickerDialog.show(appCompatActivity.fragmentManager, "TAG")
    }

    public fun getActivity(): AppCompatActivity {
        return appCompatActivity
    }

}