package com.tpa.xuiframwork.activity

import android.os.Bundle
import android.view.View
import com.tpa.xuiframework.activity.XActionBarDrawerActivity
import com.tpa.xuiframework.log
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.fragment.BindingAdapterFragment
import com.tpa.xuiframwork.fragment.PaginationAdapterFragment
import com.tpa.xuiframwork.fragment.SimpleAdapterFragment


class MainActivity : XActionBarDrawerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setDrawerView(R.layout.merge_drawer)


        val fragments = arrayListOf(
            SimpleAdapterFragment(),
            BindingAdapterFragment(),
            PaginationAdapterFragment()
        )

        setFragment(fragments[0], R.id.frameFragment)
        val onMenuItemClick: (View) -> Unit = {
            toggleDrawer()
            if (it.tag is String) {
                setFragment(fragments[(it.tag as String).toInt()], R.id.frameFragment)
            }
        }

        findViewById<View>(R.id.linSimpleAdapter).setOnClickListener(onMenuItemClick)
        findViewById<View>(R.id.linBindingAdapter).setOnClickListener(onMenuItemClick)
        findViewById<View>(R.id.linPaginationAdapter).setOnClickListener(onMenuItemClick)

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