package com.tpa.xuiframwork.layout

import android.view.ViewGroup
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
        }
    }

}