package com.tpa.xuiframework.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.tpa.xuiframework.R
import com.tpa.xuiframework.extention.getActivityLabel
import kotlinx.android.synthetic.main.merge_simple_drawer_layout.*

open class XActionBarDrawerActivity : XDrawerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        findViewById<View>(R.id.imgMenu).setOnClickListener {
//
//        }
    }

    override fun setContentView(layoutResID: Int) {
        val activity = createActivityView()
        layoutInflater.inflate(layoutResID, activity.findViewById(R.id.frameActionBarContent))
        super.setContentView(activity)
    }

    override fun setContentView(view: View?) {
        val activity = createActivityView()
        activity.findViewById<ViewGroup>(R.id.frameActionBarContent).addView(view)
        super.setContentView(activity)
    }

    override fun onContentViewSet() {
        imgMenu?.setOnClickListener({
            toggleDrawer()
        })

        val title = getActivityLabel()
        if (title != null) {
            textAppbarTitle?.text = title
        }
    }

    private fun createActivityView(): View {
        return layoutInflater.inflate(R.layout.activity_actionbar_drawer, null);
    }
}