package com.mohamadamin.persianmaterialdatetimepicker.utils

import java.util.*



fun PersianCalendar.getFormatedPersianDate(format: Int): String {
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

fun PersianCalendar.getPersianDateFullFormat(): String {
    val DATE_FORMAT = "%02d %s %04d"

    return java.lang.String.format(
        Locale.US,
        DATE_FORMAT,
        this.persianDay,
        this.persianMonthName,
        this.persianYear
    )
}

fun PersianCalendar.setPersianDateTime(
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

fun PersianCalendar.setPersianDate(
    day: Int,
    month: Int,
    year: Int
): PersianCalendar {
    val persianCalendar = PersianCalendar()
    persianCalendar.setPersianDate(year, month, day)
    persianCalendar.set(Calendar.HOUR_OF_DAY, 0)
    persianCalendar.set(Calendar.MINUTE, 0)
    persianCalendar.set(Calendar.SECOND, 0)
    persianCalendar.set(Calendar.MILLISECOND, 0)

    return persianCalendar
}
