package com.tpa.xuiframework.utils

import android.content.Context
import android.graphics.Typeface
import android.util.TypedValue
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar
import com.tpa.xuiframework.R
import com.tpa.xuiframework.XConfig
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern


class XUtil {
    companion object {
        val DATE_FORMAT_SHORT: Int = 1
        val DATE_FORMAT_FULL: Int = 2

        public fun getTypeface(path: String): Typeface {
            return Typeface.createFromAsset(XConfig.app.assets, path);
        }

        public fun getAccentColor(context: Context): Int {
            val typedValue = TypedValue()

            val a = context.obtainStyledAttributes(typedValue.data, intArrayOf(R.attr.colorAccent))
            val color = a.getColor(0, 0)

            a.recycle()

            return color
        }

        fun showSnackbar(view: View, text: String) {
            Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
        }

        fun getPersianNo(text: Int): String {
            return getPersianNo(text.toString())
        }


        fun getPersianNo(text: String): String {
            return if (!text.isEmpty()) {
                text.replace("1".toRegex(), "١").replace("2".toRegex(), "٢")
                    .replace("3".toRegex(), "٣").replace(
                        "4".toRegex(), "٤"
                    ).replace("5".toRegex(), "٥").replace("6".toRegex(), "٦").replace(
                        "7".toRegex(), "٧"
                    ).replace("8".toRegex(), "٨").replace("9".toRegex(), "٩").replace(
                        "0".toRegex(), "٠"
                    )
            } else {
                ""
            }
        }

        fun getPersianDate(
            format: Int,
            persianCalendar: PersianCalendar = PersianCalendar()
        ): String {
            persianCalendar.set(Calendar.HOUR_OF_DAY, 0)
            persianCalendar.set(Calendar.MINUTE, 0)
            persianCalendar.set(Calendar.SECOND, 0)
            persianCalendar.set(Calendar.MILLISECOND, 0)

            if (format == DATE_FORMAT_SHORT) {
                return getPersianNo(persianCalendar.persianDay) + " " + persianCalendar.persianMonthName
            } else if (format == DATE_FORMAT_FULL) {
                val DATE_FORMAT = "%02d %s %04d"

                return getPersianNo(
                    String.format(
                        DATE_FORMAT,
                        persianCalendar.persianDay,
                        persianCalendar.persianMonthName,
                        persianCalendar.persianYear
                    )
                )
            }
            return ""
        }

        fun getPersianDateTime(
            format: Int,
            persianCalendar: PersianCalendar = PersianCalendar()
        ): String {
            persianCalendar.set(Calendar.SECOND, 0)
            persianCalendar.set(Calendar.MILLISECOND, 0)

            if (format == DATE_FORMAT_SHORT) {
                return getPersianNo(
                    persianCalendar.persianDay.toString() + " " + persianCalendar.persianMonthName + " " +
                            persianCalendar.get(Calendar.HOUR_OF_DAY).toString() + ":" + persianCalendar.get(
                        Calendar.MINUTE
                    ).toString()
                )
            } else if (format == DATE_FORMAT_FULL) {
                val DATE_FORMAT = "%02d %s %04d %02d:%02d"

                return getPersianNo(
                    String.format(
                        DATE_FORMAT,
                        persianCalendar.persianDay,
                        persianCalendar.persianMonthName,
                        persianCalendar.persianYear
                    )
                )
            }
            return ""
        }

        fun getPersianDate(format: Int, date: Long): String {
            val persianCalendar = PersianCalendar()
            persianCalendar.timeInMillis = date

            return getPersianDate(format, persianCalendar)
        }

        fun getPersianDate(format: Int, day: Int, month: Int, year: Int): String {
            val persianCalendar = PersianCalendar()
            persianCalendar.setPersianDate(year, month, day)

            return getPersianDate(format, persianCalendar)
        }

        fun getPersianDateTime(
            format: Int,
            day: Int,
            month: Int,
            year: Int,
            hour: Int,
            min: Int
        ): String {
            val persianCalendar = PersianCalendar()
            persianCalendar.setPersianDate(year, month, day)
            persianCalendar.set(Calendar.HOUR_OF_DAY, hour)
            persianCalendar.set(Calendar.MINUTE, min)

            return getPersianDateTime(format, persianCalendar)
        }

        fun getMilis(
            format: Int,
            day: Int,
            month: Int,
            year: Int,
            hour: Int,
            min: Int
        ): Long {

        }

        fun getMilis(
            time: Long
        ): PersianCalendar {

        }


        fun isValidIranTel(tel: String): Boolean {
            val pattern: Pattern
            val matcher: Matcher
            val TEL_PATTERN = "^(09|۰۹)([0-9]|[۰-۹]){9}$"
            pattern = Pattern.compile(TEL_PATTERN)
            matcher = pattern.matcher(tel)
            return matcher.matches()
        }

        fun isEmailValid(email: String): Boolean {
            val EMAIL_PATTERN =
                Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
            val matcher = EMAIL_PATTERN.matcher(email)
            return matcher.matches()
        }

        fun isIranNationalIdValid(melliCode: String): Boolean {
            if (melliCode.trim { it <= ' ' }.isEmpty()) {
                return false // Melli Code is empty
            } else if (melliCode.length != 10) {
                return false // Melli Code is less or more than 10 digits
            } else {
                var sum = 0

                for (i in 0..8) {
                    sum += Character.getNumericValue(melliCode[i]) * (10 - i)
                }

                val lastDigit: Int
                val divideRemaining = sum % 11

                if (divideRemaining < 2) {
                    lastDigit = divideRemaining
                } else {
                    lastDigit = 11 - divideRemaining
                }

                return if (Character.getNumericValue(melliCode[9]) == lastDigit) {
                    true
                } else {
                    false // Invalid MelliCode
                }
            }
        }

    }
}


//not null
fun <T> NN(any: T?, op: ((it: T) -> Any)){
    if (any != null){
        op(any)
    }
}