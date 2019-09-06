package com.tpa.xuiframwork.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tpa.xuiframwork.layout.CustomViewsFragmentLayout
import org.jetbrains.anko.AnkoContext

class CustomViewsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return CustomViewsFragmentLayout().createView(AnkoContext.create(context!!, container!!))
    }
}