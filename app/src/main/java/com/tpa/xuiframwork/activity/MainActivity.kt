package com.tpa.xuiframwork.activity

import android.os.Bundle
import android.widget.CompoundButton
import com.hvd.xcustomview.activity.XActionBarDrawerActivity
import com.tpa.formbuilder.log
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.fragment.*
import com.tpa.xuiframwork.layout.DrawerViewLayout
import com.tpa.xuiframwork.layout.MainActivityLayout
import org.jetbrains.anko.sdk27.coroutines.onCheckedChange
import org.jetbrains.anko.setContentView


class MainActivity : XActionBarDrawerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainLayout = MainActivityLayout()
        mainLayout.setContentView(this)

        val fragments = arrayListOf(
            SimpleAdapterFragment(),
            MultiSelectFragment(),
            PaginationAdapterFragment(),
            CustomViewsFragment(),
            FormBuilderFragment(),
            AutoFormFragment(),
            DataFragment()
        )

        setFragments(fragments)

        val drawerView = DrawerViewLayout { s: String, i: Int ->
            toggleDrawer()
            setFragment(i, R.id.frameFragment)
        }
        setFragment(0, R.id.frameFragment)

        setDrawerView(drawerView)

        log("logged")

        findViewById<CompoundButton>(R.id.switchRtl).onCheckedChange { buttonView, isChecked ->
            setLanguage(if (isChecked) "fa" else "en")
        }
    }

    override fun getActionbarXml(): Int {
        return R.layout.merge_switch_drawer_layout
    }
}