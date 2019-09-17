package com.tpa.xuiframework.activity

import com.akexorcist.localizationactivity.ui.LocalizationActivity

abstract class XActivity: LocalizationActivity() {

    protected fun getActivity(): XActivity{
        return this
    }

}