package com.tpa.xuiframework.activity

import android.app.Activity

open abstract class XActivity: Activity() {
    protected fun getActivity(): XActivity{
        return this
    }
}