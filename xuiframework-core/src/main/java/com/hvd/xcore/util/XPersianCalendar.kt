package com.hvd.xcore.util

import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar
import java.util.*


class XPersianCalendar() : PersianCalendar() {

    companion object {
        val DATE_FORMAT_SHORT = 1
        val DATE_FORMAT_FULL = 2
    }

    constructor(date: Long) : this() {
        timeInMillis = date
    }

    constructor(persianYear: Int, persianMonth: Int, persianDay: Int) : this() {
        setPersianDate(persianYear, persianMonth, persianDay)
    }

    constructor(
        day: Int,
        month: Int,
        year: Int,
        hour: Int,
        min: Int
    ) : this() {
        setPersianDateTime(day, month, year, hour, min)
    }

    fun getFormatedPersianDate(format: Int): String {
        if (format == PersianCalendar.DATE_FORMAT_FULL) {
            return this.getPersianDateFullFormat()
        } else if (format == PersianCalendar.DATE_FORMAT_SHORT) {
            return this.getPersianDateShortFormat();
        }
        throw IllegalStateException("wrong")
    }

    fun PersianCalendar.getPersianDateShortFormat(): String {
        return "${this.persianDay} ${this.persianMonthName}"
    }

    fun getPersianDateFullFormat(): String {
        val DATE_FORMAT = "%02d %s %04d"

        return java.lang.String.format(
            Locale.US,
            DATE_FORMAT,
            this.persianDay,
            this.persianMonthName,
            this.persianYear
        )
    }

    fun setPersianDateTime(
        day: Int,
        month: Int,
        year: Int,
        hour: Int,
        min: Int
    ): PersianCalendar {
        val persianCalendar = PersianCalendar()
        persianCalendar.setPersianDate(year, month, day)
        persianCalendar.set(Calendar.HOUR_OF_DAY, hour)
        persianCalendar.set(Calendar.MINUTE, min)
        persianCalendar.set(Calendar.SECOND, 0)
        persianCalendar.set(Calendar.MILLISECOND, 0)

        return persianCalendar
    }

    override fun setPersianDate(
        day: Int,
        month: Int,
        year: Int
    ) {
        val persianCalendar = PersianCalendar()
        persianCalendar.setPersianDate(year, month, day)
        persianCalendar.set(Calendar.HOUR_OF_DAY, 0)
        persianCalendar.set(Calendar.MINUTE, 0)
        persianCalendar.set(Calendar.SECOND, 0)
        persianCalendar.set(Calendar.MILLISECOND, 0)
    }

}