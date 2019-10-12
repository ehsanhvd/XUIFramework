package com.tpa.xuiframework.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.tpa.xuiframework.R
import com.tpa.xuiframework.extention.addView
import com.tpa.xuiframework.extention.getActivityLabel
import kotlinx.android.synthetic.main.activity_drawer.*
import kotlinx.android.synthetic.main.merge_simple_drawer_layout.*
import org.jetbrains.anko.AnkoComponent

abstract class XActionBarDrawerActivity : XDrawerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        findViewById<View>(R.id.imgMenu).setOnClickListener {
//
//        }
    }

    override fun setContentView(layoutResID: Int) {
        val activityView = createActivityView()
        layoutInflater.inflate(layoutResID, activityView.findViewById(R.id.frameActionBarContent))
        createActionBar(activityView.findViewById((R.id.frameDrawerContainer)));
        super.setContentView(activityView)
    }

    override fun setContentView(view: View?) {
        val activityView = createActivityView()
        activityView.findViewById<ViewGroup>(R.id.frameActionBarContent).addView(view)
        createActionBar(activityView.findViewById((R.id.frameDrawerContainer)))
        super.setContentView(activityView)
    }

    private fun createActionBar(parent: ViewGroup) {
        val ankoComp = getActionbar()
        if (ankoComp != null) {
            frameDrawer.addView(getActivity(), ankoComp)
        } else {
            layoutInflater.inflate(getActionbarXml(), parent)
        }
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

    open protected fun getActionbar(): AnkoComponent<ViewGroup>? {
        return null
    }

    open protected fun getActionbarXml(): Int {
        return R.layout.merge_simple_drawer_layout
    }
}