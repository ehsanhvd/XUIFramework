package com.tpa.xuiframwork.dialog

import android.app.Dialog
import android.content.Context
import android.view.ViewGroup
import com.tpa.xuiframework.utils.BaseMaterialDialog
import com.tpa.xuiframwork.layout.TestMaterialAnkoLayout
import org.jetbrains.anko.AnkoComponent

class TestMaterialDialog(context: Context, okListener: ((Dialog) -> Unit)) : BaseMaterialDialog(context, okListener) {
    override fun getAnkoContent(): AnkoComponent<ViewGroup>? {
        return TestMaterialAnkoLayout()
    }
}