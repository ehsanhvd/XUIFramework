package com.tpa.xuiframework.activity

import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity

open abstract class XActivity: AppCompatActivity() {

    protected fun getActivity(): XActivity{
        return this
    }

    protected fun getActivityLabel(): String? {
        try {
            val stringRes = this.packageManager.getActivityInfo(this.componentName, 0).labelRes
            if (stringRes != 0) {
                return this.resources.getString(stringRes)
            }
        } catch (var2: PackageManager.NameNotFoundException) {
            var2.printStackTrace()
        }

        return null
    }

}