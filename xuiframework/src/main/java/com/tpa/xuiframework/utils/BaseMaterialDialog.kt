package com.tpa.xuiframework.utils

import android.app.Dialog
import android.content.Context
import android.view.Window
import com.tpa.xuiframework.R

class BaseMaterialDialog(context: Context): Dialog(context, R.style.DialogTheme) {
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.material_dialog)
    }
}