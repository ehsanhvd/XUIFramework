package com.tpa.xuiframwork.layout

import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog
import com.mohamadamin.persianmaterialdatetimepicker.time.TimePickerDialog
import com.tpa.xuiframework.utils.Dialogs
import com.tpa.xuiframework.utils.XDatePicker
import com.tpa.xuiframework.utils.XDateTimePicker
import com.tpa.xuiframework.view.customSpinner
import com.tpa.xuiframwork.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class CustomViewsFragmentLayout(val appCompatActivity: AppCompatActivity) : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            customSpinner(R.array.testArray) {


            }.lparams(wrapContent, wrapContent)


            linearLayout {
                button("ask dialog") {
                    onClick {
                        Dialogs.ask(ui.ctx, "this is a title", " this is a question?") {
                            it.dismiss()
                        }.show()
                    }

                }.lparams {
                    weight = 1F
                }
                button("info dialog") {
                    onClick {
                        Dialogs.alert(ui.ctx, "this is a title", "this is an info") {
                            it.dismiss()
                        }.show()
                    }
                }.lparams {
                    weight = 1F
                }
            }
            linearLayout {
                button("Date picker") {
                    onClick {
                        val datePicker = XDatePicker(appCompatActivity).showDatePicker { datePickerDialog: DatePickerDialog, i: Int, i1: Int, i2: Int ->

                        }
                    }
                }.lparams {
                    weight = 1F
                }
                button("Date Time picker") {
                    onClick {
                        val datePicker = XDateTimePicker(appCompatActivity).showDateTimePicker { timePickerDialog: TimePickerDialog, i: Int, i1: Int, i2: Int, i3: Int, i4: Int ->

                        }
                    }
                }.lparams {
                    weight = 1F
                }
            }
            button("Buttom nav activity") {
                onClick {
                    ButtomNavActivity.start(appCompatActivity)
                }
            }


        }
    }

}