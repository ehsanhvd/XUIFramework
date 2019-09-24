package com.tpa.xuiframework.view

import android.content.Context
import android.util.AttributeSet
import android.widget.RadioButton
import com.tpa.xuiframework.R
import com.tpa.xuiframework.XConfig

class CustomRadiobutton(context: Context, val attrs: AttributeSet?, val defStyleAttr: Int) :
    RadioButton(context, attrs, defStyleAttr) {

    constructor(context: Context) : this(context, null, 0)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    init {
        val ta = getContext().obtainStyledAttributes(attrs, R.styleable.CustomButton, defStyleAttr, 0)
        val fontI = ta.getInt(R.styleable.CustomButton_fontIndex, 0)

        setTypeface(XConfig.typefaces[fontI])
        ta.recycle()
    }
}