package com.tpa.xuiframwork.layout

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.tpa.xuiframework.form.Form
import com.tpa.xuiframework.utils.XUtil
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.entity.TestData
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout

class FormBuilderFragmentLayout(val appCompatActivity: AppCompatActivity) : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            val testData = TestData("test")
//            Form.with(this, testData)
            Form.with(appCompatActivity, this).editText("text 1").editText("text 2")
                .row()
                .editText("text 3").button("do something") {
                    toast("done something")
                }
                .row()
                .editText(id = R.id.editAnother).depends(R.id.checkTest).checkbox("is something", id = R.id.checkTest, checked = true)
                .text("some label", id = R.id.textLabel).depends(R.id.checkTest)
                .row()
                .spinner(R.array.testArray).datePicker(format = XUtil.DATE_FORMAT_FULL)
                .row().dateTimePicker(hint = "some date")
                .radioGroup(orientation = LinearLayout.VERTICAL).radioButton("some option", id = R.id.radioOption).radioButton("another option")
                .row().editText("some dependant text", id = R.id.textDependant).depends(R.id.radioOption)
                .finish()
        }
    }

}