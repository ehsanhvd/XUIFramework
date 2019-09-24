package com.tpa.xuiframwork.layout

import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.*

class TestMaterialAnkoLayout : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            verticalLayout {

                textView("custom view in dialog using anko").lparams{
                    margin = dip(15)
                }
            }
        }
    }


}