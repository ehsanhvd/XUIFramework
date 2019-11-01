package com.tpa.xuiframework.view

import android.content.Context
import android.util.AttributeSet
import com.tpa.xuiframework.utils.XUtil
import org.jetbrains.anko.singleLine

open class BaseDatePickerTextView : CustomEditText {

    var format = XUtil.DATE_FORMAT_SHORT

    var time = 0L

    constructor(context: Context) : super(context)

    constructor(context: Context, format: Int) : super(context){
        this.format = format
    }

    constructor(context: Context, attrs : AttributeSet) : super(context,attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr : Int) : super(context, attrs, defStyleAttr)

    init {
        singleLine = true
        setFocusable(false)
        setClickable(false)
        setLongClickable(false)
    }
}