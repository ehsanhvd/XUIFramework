package com.tpa.xuiframework.view

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class XFragmentPagerAdapter(fm: FragmentManager, vararg fragments: Fragment) : FragmentPagerAdapter(fm) {

    val fragments = fragments;

    override fun getItem(index: Int): Fragment {
        return fragments[index]
    }

    override fun getCount(): Int {
        return fragments.size
    }


}