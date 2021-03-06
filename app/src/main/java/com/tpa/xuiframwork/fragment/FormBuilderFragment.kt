package com.tpa.xuiframwork.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tpa.xuiframwork.layout.FormBuilderFragmentLayout
import org.jetbrains.anko.AnkoContext

class FormBuilderFragment : com.hvd.xcustomview.fragment.XFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FormBuilderFragmentLayout(activity as com.hvd.xcustomview.activity.XActivity).createView(AnkoContext.create(context!!, container!!))
    }
}