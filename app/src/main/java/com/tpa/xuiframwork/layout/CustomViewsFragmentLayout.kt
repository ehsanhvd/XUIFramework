package com.tpa.xuiframwork.layout

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog
import com.mohamadamin.persianmaterialdatetimepicker.time.TimePickerDialog
import com.tpa.xuiframework.adapter.XAdapter
import com.tpa.xuiframework.utils.Dialogs
import com.tpa.xuiframework.utils.XDatePicker
import com.tpa.xuiframework.utils.XDateTimePicker
import com.tpa.xuiframework.utils.XImagePicker
import com.tpa.xuiframework.view.customSpinner
import com.tpa.xuiframework.view.expandablelayout.expandableLayout
import com.tpa.xuiframework.view.glideImageView
import com.tpa.xuiframework.view.glideImageViewCircle
import com.tpa.xuiframework.view.horizontalrecyclerview.xhorizontalRecyclerView
import com.tpa.xuiframwork.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class CustomViewsFragmentLayout(
    val appCompatActivity: AppCompatActivity,
    val xImagePicker: XImagePicker
) : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        scrollView {
            verticalLayout {
                expandableLayout {
                    linearLayout {
                        backgroundColor = Color.parseColor("#afafaf")
                        textView("Expandable layout") {
                            textSize = 17f
                            gravity = Gravity.CENTER_VERTICAL
                        }.lparams(dip(0), dip(40), 1f)
                        imageView {
                            tag = "imgIndicator"
                            scaleType = ImageView.ScaleType.CENTER_INSIDE
                            imageResource = R.drawable.ic_arrow_drop_down_black_24dp
                        }.lparams(dip(40), dip(40))
                        onClick {
                            if (isExpanded) {
                                collapse()
                            } else {
                                expand()
                            }
                        }
                    }
                    linearLayout {
                        backgroundColor = Color.parseColor("#cccccc")
                        textView("Expanded view").lparams(matchParent, dip(100))
                        visibility = View.GONE //TODO anko only
                    }
                }.lparams(matchParent, wrapContent) {
                    bottomMargin = dip(10)
                }

                verticalLayout {
                    linearLayout {
                        gravity = Gravity.CENTER

                        textView("easy spinner: ").lparams(weight = 1f) {
                            margin = dip(10)
                        }
                        customSpinner(R.array.testArray).lparams(weight = 1f)
                    }.lparams {
                        bottomMargin = dip(10)
                    }

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
                        button("input dialog") {
                            onClick {
                                Dialogs.inputDialog(
                                    ui.ctx,
                                    "this is a title",
                                    hint = "this is a hint"
                                ) {
                                    it.dismiss()
                                }.show()
                            }
                        }.lparams {
                            weight = 1F
                        }
                    }.lparams(matchParent, wrapContent) {
                        bottomMargin = dip(10)
                    }

                    linearLayout {
                        button("Jalali date picker") {
                            onClick {
                                val datePicker =
                                    XDatePicker(appCompatActivity).showDatePicker { datePickerDialog: DatePickerDialog, year: Int, month: Int, day: Int -> }
                            }
                        }.lparams {
                            weight = 1F
                        }
                        button("Jalali date Time picker") {
                            onClick {
                                val datePicker =
                                    XDateTimePicker(appCompatActivity).showDateTimePicker { timePickerDialog: TimePickerDialog, year: Int, month: Int, day: Int, hour: Int, min: Int -> }
                            }
                        }.lparams {
                            weight = 1F
                        }
                    }.lparams(matchParent, wrapContent) {
                        bottomMargin = dip(10)
                    }

                    linearLayout {
                        gravity = Gravity.CENTER_VERTICAL
                        textView("Round\nimage picker").lparams {
                            marginStart = dip(10)
                        }
                        glideImageViewCircle {
                            imageResource = R.drawable.gray_circle
                            onClick {
                                xImagePicker.startWithFragment {
                                    setImageURI(it)
                                }
                            }
                        }.lparams(dip(80), dip(80)) {
                            marginStart = dip(10)
                        }

                        textView("Image picker").lparams {
                            marginStart = dip(10)
                        }
                        glideImageView {
                            imageResource = R.drawable.gray_rect
                            onClick {
                                xImagePicker.startWithFragment {
                                    setImageURI(it)
                                }
                            }
                        }.lparams(dip(80), dip(80)) {
                            marginStart = dip(10)
                        }
                    }.lparams(matchParent, wrapContent) {
                        bottomMargin = dip(10)
                    }
                    xhorizontalRecyclerView {
                        adapter = XAdapter(
                            R.layout.row_horizontal_recycler,
                            arrayListOf("item1", "item2", "item3", "item4"),
                            { view: View, s: String, i: Int -> })
                    }.lparams(matchParent, wrapContent) {
                        bottomMargin = dip(10)
                    }

                }
            }
        }
    }

}