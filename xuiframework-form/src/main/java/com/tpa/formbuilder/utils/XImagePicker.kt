package com.tpa.formbuilder.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.fragment.app.Fragment
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView


class XImagePicker {



    constructor(activity: Activity, listener: (Uri) -> Unit){
        this@XImagePicker.activity = activity
        this@XImagePicker.listener = listener
    }

    constructor(context: Context, fragment: Fragment, listener: ((Uri) -> Unit)){
        this@XImagePicker.context = context
        this@XImagePicker.fragment = fragment
        this@XImagePicker.listener = listener
    }

    constructor(activity: Activity){
        this@XImagePicker.activity = activity
    }

    constructor(context: Context, fragment: Fragment){
        this@XImagePicker.context = context
        this@XImagePicker.fragment = fragment
    }

    private lateinit var activity: Activity
    private lateinit var fragment: Fragment
    private lateinit var context: Context
    private lateinit var listener: (Uri) -> Unit

    fun startWithActivity(){
        CropImage.activity()
            .setGuidelines(CropImageView.Guidelines.ON)
            .start(activity)
    }

    fun startWithFragment(){
        CropImage.activity()
            .start(context, fragment)
    }

    fun startWithActivity(listener: ((Uri) -> Unit)){
        this@XImagePicker.listener = listener
        CropImage.activity()
            .setGuidelines(CropImageView.Guidelines.ON)
            .start(activity)
    }

    fun startWithFragment(listener: ((Uri) -> Unit)){
        this@XImagePicker.listener = listener
        CropImage.activity()
            .start(context, fragment)
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            val result = CropImage.getActivityResult(data)
            if (resultCode == Activity.RESULT_OK) {
                val resultUri = result.uri
                listener(resultUri)
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                val error = result.error
            }
        }
    }
}