package com.tpa.xuiframwork.dialog

import android.app.Dialog
import android.content.Context
import com.tpa.xuiframework.utils.BaseMaterialDialog
import com.tpa.xuiframwork.R

class TestMaterialDialog(context: Context, okListener: ((Dialog) -> Unit) = {}) : BaseMaterialDialog(context, okListener) {

    //use anko layout this way
//    override fun getAnkoContent(): AnkoComponent<ViewGroup>? {
//        return TestMaterialAnkoLayout()
//    }

    override fun getContent(): Int? {
        return R.layout.dialog_test_material
    }
}