package com.tpa.xuiframework

import android.content.Context
import android.graphics.Typeface
import android.util.TypedValue


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
    }
}