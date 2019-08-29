package com.tpa.xuiframework.activity

import android.support.v7.app.AppCompatActivity

open abstract class XActivity: AppCompatActivity() {

    protected fun getActivity(): XActivity{
        return this
    }

}