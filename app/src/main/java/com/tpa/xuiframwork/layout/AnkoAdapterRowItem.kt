package com.tpa.xuiframwork.layout

import android.view.View
import android.view.ViewGroup
import com.hvd.xcustomview.view.glideImageView
import com.tpa.xuiframwork.App
import com.tpa.xuiframwork.R
import org.jetbrains.anko.*

class AnkoAdapterRowItem : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                glideImageView{
                    id = R.id.imageProfile
                    defDrawable = App.app.resources.getDrawable(R.drawable.ic_launcher)
                }.lparams(dip(100), dip(100))

                textView() {
                    id = R.id.textTitle
                    textSize = 13f
                }.lparams {
                    margin = dip(15)
                }
            }
        }
    }

}

