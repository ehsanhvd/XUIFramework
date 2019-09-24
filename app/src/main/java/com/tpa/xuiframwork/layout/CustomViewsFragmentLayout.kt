package com.tpa.xuiframwork.layout

import android.view.ViewGroup
import com.tpa.xuiframework.utils.Dialogs
import com.tpa.xuiframwork.dialog.TestMaterialDialog
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class CustomViewsFragmentLayout : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            button("selector") {
                onClick {
                    val countries = listOf("آیتم ۱", "آیتم ۲", "آیتم ۳", "آیتم ۴")
                    selector("انتخاب گر", countries, { dialogInterface, i ->
                        toast(" ${countries[i]} انتخاب شد")
                    })
                }
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
            }
            button("custom material dialog") {
                onClick {
                    TestMaterialDialog(ui.ctx){
                        it.dismiss()
                    }.show()
                }
            }

        }
    }

}