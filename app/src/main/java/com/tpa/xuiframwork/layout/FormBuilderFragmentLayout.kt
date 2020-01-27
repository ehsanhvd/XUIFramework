package com.tpa.xuiframwork.layout

import android.view.ViewGroup
import android.widget.LinearLayout
import com.hvd.xcore.extention.showSnackbar
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar
import com.tpa.xuiframework.activity.XActivity
import com.tpa.xuiframework.form.Form
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.entity.TestData
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.verticalLayout

class FormBuilderFragmentLayout(val xActivity: XActivity) :
    AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            val testData = TestData("test")
//            Form.with(this, testData)

            val form = Form.with(xActivity, this).editText("text 1").editText("text 2")
                .row()
                .editText("text 3").button("do something") {
                    xActivity.showSnackbar("done something")
                }
                .row()
                .checkbox("Checkbox", id = R.id.checkTest)
                .editText(hint = "dependant edit", id = R.id.editAnother).dependsOn(R.id.checkTest)
                .text("dependant label", id = R.id.textLabel).dependsOn(R.id.checkTest)
                .row()
                .spinner(R.array.testArray).space().space()
                .row()
                .datePicker(hint = "Jalali date picker", format = PersianCalendar.DATE_FORMAT_FULL).dateTimePicker(hint = "some date")
                .row()
                .radioGroup(orientation = LinearLayout.VERTICAL)
                .radioButton("some option", id = R.id.radioOption).radioButton("another option")
                .row()
                .editText("some dependant text", id = R.id.textDependant).dependsOn(R.id.radioOption)
                .checkbox("wrap check", R.id.checkWrapDep).wrapContent().dependsOn(R.id.radioOption)
                .row().row()
                .iranTelInput(hint = "iran tel")
                .emailInput(hint ="mandatory email", mandatory = true)
                .finish()

            button("Validate edit texts") {
                onClick {
                    form.validateForm { editText, isValid ->
                        if (!isValid) {
                            editText.setError("error")
                        }
                    }
                }
            }
        }
    }

}