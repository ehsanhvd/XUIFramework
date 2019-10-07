package com.tpa.xuiframework.utils

import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar

class XPersianCalendar(): PersianCalendar() {

    constructor(date: Long):this(){
        timeInMillis = date
    }
}