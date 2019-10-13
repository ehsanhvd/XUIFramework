package com.tpa.xuiframwork.layout

import android.view.Gravity
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog
import com.mohamadamin.persianmaterialdatetimepicker.time.TimePickerDialog
import com.tpa.xuiframework.utils.Dialogs
import com.tpa.xuiframework.utils.XDatePicker
import com.tpa.xuiframework.utils.XDateTimePicker
import com.tpa.xuiframework.utils.XImagePicker
import com.tpa.xuiframework.view.customSpinner
import com.tpa.xuiframework.view.glideImageViewCircle
import com.tpa.xuiframwork.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class CustomViewsFragmentLayout(val appCompatActivity: AppCompatActivity, val xImagePicker: XImagePicker) : AnkoComponent<ViewGroup> {
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
            linearLayout {
                gravity = Gravity.CENTER_VERTICAL
                textView("Image picker").lparams {
                    marginStart = dip(20)
                }
                glideImageViewCircle {
                    backgroundResource = R.drawable.gray_circle
                    onClick {
                        xImagePicker.startWithFragment {
                            setImageURI(it)
                        }
                    }
                }.lparams(dip(100),dip(100)) {
                    marginStart = dip(20)
                }
            }
        }
    }

}