package com.tpa.xuiframework.view

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

class CustomTextView(context: Context, val attrs: AttributeSet?, val defStyleAttr: Int) :
    TextView(context, attrs, defStyleAttr) {
    constructor(context: Context) : this(context, null, 0)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    init {
//        val ta = getContext().obtainStyledAttributes(attrs, R.styleable.CustomTextView, defStyleAttr, 0)
//        val textStyle = ta.getInt(R.styleable.CustomTextView_textStyle, 3) //2 is medium
//
//        when (textStyle) {
//            1 -> setTypeface(Typeface.createFromAsset(getContext().assets, "font/Vazir-Light.ttf"))
//            2 -> setTypeface(TravelApp.getInstance().getTypefaceLight())
//            3 -> setTypeface(TravelApp.getInstance().getRegularTypeface())
//            4 -> setTypeface(TravelApp.getInstance().getTypefaceBold())
//            else -> setTypeface(TravelApp.getInstance().getRegularTypeface())
//        }
//        ta.recycle()
    }
}