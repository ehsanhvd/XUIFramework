package com.tpa.xuiframwork.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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