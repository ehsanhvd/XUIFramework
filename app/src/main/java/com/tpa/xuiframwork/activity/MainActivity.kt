package com.tpa.xuiframwork.activity

import android.os.Bundle
import android.view.ViewGroup
import com.tpa.xuiframework.activity.XActionBarDrawerActivity
import com.tpa.xuiframework.log
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.fragment.BindingAdapterFragment
import com.tpa.xuiframwork.fragment.PaginationAdapterFragment
import com.tpa.xuiframwork.fragment.SimpleAdapterFragment
import com.tpa.xuiframwork.layout.DrawerView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.setContentView


class MainActivity : XActionBarDrawerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainActivityLayout().setContentView(this);

        val fragments = arrayListOf(
            SimpleAdapterFragment(),
            BindingAdapterFragment(),
            PaginationAdapterFragment()
        )

        val drawerView = DrawerView { s: String, i: Int ->
            toggleDrawer()
            setFragment(fragments[i], R.id.frameFragment)
        }.createView(AnkoContext.create(getActivity(), findViewById<ViewGroup>(R.id.frameDrawer)));

        setFragment(fragments[0], R.id.frameFragment)

        setDrawerView(drawerView)

        log("logged")

//        xRequest("gettravels") {
//            type = XRequest.Type.TYPE_GET
//            + Param("limit", 10)
//            + Param("skip", 0)
//            + Param("version", 3)
//        }.start({
//
//        }, {
//
//        })
    }

}