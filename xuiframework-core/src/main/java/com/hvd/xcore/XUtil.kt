package com.hvd.xcore

import android.content.Context
import android.graphics.Typeface
import android.util.TypedValue
import android.view.View
import com.google.android.material.snackbar.Snackbar
import java.util.regex.Matcher
import java.util.regex.Pattern


class XUtil {
    companion object {
        public fun getTypeface(path: String): Typeface {
            if (XConfig.app == null){
                throw IllegalStateException("please set app context to XConfig")
            }
            return Typeface.createFromAsset(XConfig.app!!.assets, path);
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

                return Character.getNumericValue(melliCode[9]) == lastDigit
            }
        }

    }
}


//not null
fun <T> NN(any: T?, op: ((it: T) -> Any)) {
    if (any != null) {
        op(any)
    }
}

//not null and not empty string
fun NNE(string: String?, op: ((it: String) -> Any)) {
    if (string != null && !string.isEmpty() && !string.equals("null")) {
        op(string)
    }
}