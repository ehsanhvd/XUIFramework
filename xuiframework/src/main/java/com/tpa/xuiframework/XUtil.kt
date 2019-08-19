package com.tpa.xuiframework

import android.graphics.Typeface

class XUtil {
    companion object {
        public fun getTypeface(path: String): Typeface {
            return Typeface.createFromAsset(XConfig.app.assets, path);
        }
    }
}