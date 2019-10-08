package com.tpa.xuiframwork.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tpa.xuiframwork.layout.FormBuilderFragmentLayout
import org.jetbrains.anko.AnkoContext

class FormBuilderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FormBuilderFragmentLayout(activity as AppCompatActivity).createView(AnkoContext.create(context!!, container!!))
    }
}