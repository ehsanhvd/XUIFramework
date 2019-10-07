package com.tpa.xuiframework.utils

import android.content.Context
import android.graphics.Typeface
import android.support.design.widget.Snackbar
import android.util.TypedValue
import android.view.View
import com.tpa.xuiframework.R
import com.tpa.xuiframework.XConfig


class XUtil {
    companion object {
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
    }
}