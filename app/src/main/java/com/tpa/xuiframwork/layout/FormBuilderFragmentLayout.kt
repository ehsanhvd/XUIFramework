package com.tpa.xuiframwork.layout

import android.support.v4.view.GravityCompat
import android.view.ViewGroup
import com.tpa.xuiframework.form.Form
import com.tpa.xuiframwork.entity.TestData
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.verticalLayout

class FormBuilderFragmentLayout : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            val testData = TestData("test")
//            Form.with(this, testData)
            Form.Builder(this).editText("text 1").editText("text 2")
                .row()
                .editText("text 3").button("do something").row().editText().checkbox("is something").text("some label", gravity = GravityCompat.END)
        }
    }

}