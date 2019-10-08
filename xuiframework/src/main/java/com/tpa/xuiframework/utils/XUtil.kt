package com.tpa.xuiframework.utils

import android.content.Context
import android.graphics.Typeface
import android.support.design.widget.Snackbar
import android.util.TypedValue
import android.view.View
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar
import com.tpa.xuiframework.R
import com.tpa.xuiframework.XConfig
import java.util.*


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

        fun getPersianDate(format: Int, persianCalendar: PersianCalendar = PersianCalendar()): String {
            persianCalendar.set(Calendar.HOUR_OF_DAY, 0)
            persianCalendar.set(Calendar.MINUTE, 0)
            persianCalendar.set(Calendar.SECOND, 0)
            persianCalendar.set(Calendar.MILLISECOND, 0)

            if (format == DATE_FORMAT_SHORT){
                return getPersianNo(persianCalendar.persianDay) + " " + persianCalendar.persianMonthName
            } else if (format == DATE_FORMAT_FULL){
                val DATE_FORMAT = "%02d %s %04d"

                return getPersianNo(String.format(DATE_FORMAT, persianCalendar.persianDay, persianCalendar.persianMonthName, persianCalendar.persianYear))
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
    }
}