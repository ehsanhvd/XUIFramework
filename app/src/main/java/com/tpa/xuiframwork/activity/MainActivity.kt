package com.tpa.xuiframwork.activity

import android.os.Bundle
import com.tpa.xuiframework.activity.XActionBarDrawerActivity
import com.tpa.xuiframework.extention.showSnackbar
import com.tpa.xuiframework.log
import com.tpa.xuiframework.webservice.XRequest
import com.tpa.xuiframework.webservice.iz
import com.tpa.xuiframework.webservice.xRequest
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.fragment.AnkoAdapterFragment
import com.tpa.xuiframwork.fragment.CustomViewsFragment
import com.tpa.xuiframwork.fragment.SimpleAdapterFragment
import com.tpa.xuiframwork.layout.DrawerView
import org.jetbrains.anko.setContentView


class MainActivity : XActionBarDrawerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainLayout = MainActivityLayout()
        mainLayout.setContentView(this)

        val fragments = arrayListOf(
            SimpleAdapterFragment(),
            AnkoAdapterFragment(),
            CustomViewsFragment()
        )

        val drawerView = DrawerView { s: String, i: Int ->
            toggleDrawer()
            setFragment(fragments[i], R.id.frameFragment)
        }

        setFragment(fragments[0], R.id.frameFragment)

        setDrawerView(drawerView)

        log("logged")
        showSnackbar("Snackbar from activity")

        xRequest("gettravels") {
            type = XRequest.Type.TYPE_GET
            +("limit" iz 10)
            +("skip" iz 0)
            +("version" iz 3)
        }.start({
//            findViewById<View>(android.R.id.content).snackbar("Hi there!")

        }, {

        })
    }

}