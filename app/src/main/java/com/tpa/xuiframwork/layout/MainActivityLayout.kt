package com.tpa.xuiframwork.layout

import android.view.View
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.activity.MainActivity
import org.jetbrains.anko.*

class MainActivityLayout : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>): View {
        return with(ui) {
            verticalLayout {
                frameLayout {
                    id = R.id.frameFragment
                }.lparams(width = matchParent, height = matchParent)
            }
        }
    }
}