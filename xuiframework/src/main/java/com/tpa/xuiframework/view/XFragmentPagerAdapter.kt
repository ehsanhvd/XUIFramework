package com.tpa.xuiframework.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class XFragmentPagerAdapter(fm: FragmentManager, vararg fragments: Fragment) : FragmentPagerAdapter(fm) {

    val fragments = fragments;

    override fun getItem(index: Int): Fragment {
        return fragments[index]
    }

    override fun getCount(): Int {
        return fragments.size
    }


}