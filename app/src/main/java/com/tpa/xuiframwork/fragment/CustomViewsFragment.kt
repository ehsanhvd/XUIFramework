package com.tpa.xuiframwork.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.tpa.formbuilder.utils.XImagePicker
import com.tpa.xuiframwork.layout.CustomViewsFragmentLayout
import org.jetbrains.anko.AnkoContext

class CustomViewsFragment : com.hvd.xcustomview.fragment.XFragment() {

    private lateinit var xImagePicker: XImagePicker

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        xImagePicker = XImagePicker(context!!, this)

        return CustomViewsFragmentLayout(activity as AppCompatActivity, xImagePicker).createView(AnkoContext.create(context!!, container!!))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        xImagePicker.onActivityResult(requestCode, resultCode, data)
    }
}