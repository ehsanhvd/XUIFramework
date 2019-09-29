package com.tpa.xuiframwork.layout

import android.support.v4.view.GravityCompat
import android.view.View
import android.view.ViewGroup
import com.tpa.xuiframework.form.Form
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.entity.TestData
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.verticalLayout

class FormBuilderFragmentLayout : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            val testData = TestData("test")
//            Form.with(this, testData)
            Form.with(this).editText("text 1").editText("text 2")
                .row()
                .editText("text 3").button("do something")
                .row()
                .editText(id = R.id.editAnother).depends(R.id.checkTest, View.VISIBLE, View.INVISIBLE).checkbox("is something", id = R.id.checkTest, checked = true)
                .text("some label", gravity = GravityCompat.END, id = R.id.textLabel).depends(R.id.checkTest, View.VISIBLE, View.INVISIBLE).finish()
        }
    }

}