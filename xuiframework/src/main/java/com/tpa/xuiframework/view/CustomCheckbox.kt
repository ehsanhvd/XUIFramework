package com.tpa.xuiframework.view

import android.content.Context
import android.util.AttributeSet
import android.widget.CheckBox
import com.tpa.xuiframework.R
import com.tpa.xuiframework.XConfig

class CustomCheckbox : CheckBox {

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
        val ta = getContext().obtainStyledAttributes(attrs, R.styleable.CustomButton, defStyleAttr, 0)
        val fontI = ta.getInt(R.styleable.CustomButton_fontIndex, 0)

        setTypeface(XConfig.typefaces[fontI])
        ta.recycle()
    }
}