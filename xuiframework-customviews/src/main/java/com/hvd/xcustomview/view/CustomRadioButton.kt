package com.hvd.xcustomview.view

import android.content.Context
import android.util.AttributeSet
import android.widget.RadioButton
import com.hvd.xcustomview.R

class CustomRadioButton : RadioButton {

    var attrs : AttributeSet? = null
    var defStyleAttr : Int = 0

    constructor(context: Context) : super(context){
    }

    constructor(context: Context, attrs : AttributeSet) : super(context,attrs){
        this.attrs = attrs
    }

    constructor(context: Context,  attrs: AttributeSet , defStyleAttr : Int) : super(context, attrs, defStyleAttr){
        this.attrs = attrs
        this.defStyleAttr = defStyleAttr
    }

    init {
        val ta = getContext().obtainStyledAttributes(attrs, R.styleable.CustomRadioButton, defStyleAttr, 0)
        val fontI = ta.getInt(R.styleable.CustomRadioButton_fontIndex, 0)

        setTypeface(com.hvd.xcore.XConfig.typefaces[fontI])
        ta.recycle()
    }
}