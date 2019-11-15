package com.tpa.xuiframwork.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tpa.xuiframework.activity.XActivity
import com.tpa.xuiframework.fragment.BaseFragment
import com.tpa.xuiframwork.layout.FormBuilderFragmentLayout
import org.jetbrains.anko.AnkoContext

class FormBuilderFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FormBuilderFragmentLayout(activity as XActivity).createView(AnkoContext.create(context!!, container!!))
    }
}