package com.tpa.xuiframwork.layout

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.tpa.xuiframework.XUtil
import com.tpa.xuiframwork.App
import com.tpa.xuiframwork.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class DrawerView(val onclick: (tag: String, i: Int) -> Unit = { s: String, i: Int -> }) : AnkoComponent<ViewGroup> {

    private val menus = arrayListOf(
        R.string.simpleAdapter,
        R.string.bindingAdapter,
        R.string.paginationAdapter
    )

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            verticalLayout {

                verticalLayout {
                    backgroundColor = XUtil.getAccentColor(ui.ctx)
                }.lparams(matchParent, dip(200))

                menuItem(0)
                menuItem(1)
                menuItem(2)
            }
        }
    }


    fun LinearLayout.menuItem( i: Int): LinearLayout = verticalLayout {
        backgroundResource = R.drawable.bg_selector

        textView(menus[i]) {
            textSize = 13f
        }.lparams {
            margin = dip(15)
        }

        onClick {
            onclick(App.app.getString(menus[i]), i)
        }

    }
}

