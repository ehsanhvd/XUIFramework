package com.tpa.xuiframework.form

import android.graphics.Color
import android.text.InputFilter
import android.text.InputType
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.annotation.ArrayRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog
import com.mohamadamin.persianmaterialdatetimepicker.time.TimePickerDialog
import com.tpa.xuiframework.utils.XDatePicker
import com.tpa.xuiframework.utils.XDateTimePicker
import com.tpa.xuiframework.utils.XUtil
import com.tpa.xuiframework.view.*
import org.jetbrains.anko.singleLine
import org.jetbrains.anko.textColor
import java.lang.reflect.Field

open class Form private constructor(
    val appCompatActivity: AppCompatActivity,
    val parent: LinearLayout
) :
    CompoundButton.OnCheckedChangeListener {

    private val dependencies: ArrayList<Dependency> = arrayListOf()
    private var currentRow: LinearLayout? = null
    private var lastView: View? = null
    private var done = false

    companion object {
        fun with(parent: LinearLayout, entity: Any) {
            val fields = entity.javaClass.declaredFields

            for (m in fields) {
                if (m.isAnnotationPresent(Input::class.java)) {
                    val ta = m.getAnnotation(Input::class.java)
                    println(ta.prop + " " + getValue(entity, m))
                }
            }
        }

        fun with(appCompatActivity: AppCompatActivity, parent: LinearLayout): Form {
            return Form(appCompatActivity, parent)
        }

        private fun getValue(entity: Any, field: Field): Any? {
            field.setAccessible(true)
            return field.get(entity)
        }
    }


    fun editText(
        hint: String = "",
        text: String = "",
        maxLength: Int = 50,
        inputType: Int = InputType.TYPE_CLASS_TEXT,
        imeOpt: Int = EditorInfo.IME_ACTION_NEXT,
        id: Int = 0

    ): Form {
        val editText = CustomEditText(parent.context)
        editText.singleLine = true
        editText.setText(text)
        editText.hint = hint
        editText.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
        editText.inputType = inputType
        editText.imeOptions = imeOpt
        editText.id = id

        addRowIfNotExist()
        addViewToForm(editText)
        return this
    }

    fun datePicker(
        hint: String = "",
        text: String = "",
        format: Int = XUtil.DATE_FORMAT_SHORT,
        id: Int = 0

    ): Form {
        val editText = CustomEditText(parent.context)
        editText.singleLine = true
        editText.setText(text)
        editText.hint = hint
        editText.id = id

        editText.setFocusable(false)
        editText.setClickable(false)
        editText.setOnClickListener {
            XDatePicker(appCompatActivity).showDatePicker { datePickerDialog: DatePickerDialog, year: Int, month: Int, day: Int ->
                editText.setText(XUtil.getPersianDate(format, day, month, year))
            }
        }

        addRowIfNotExist()
        addViewToForm(editText)
        return this
    }

    fun dateTimePicker(
        hint: String = "",
        text: String = "",
        format: Int = XUtil.DATE_FORMAT_SHORT,
        id: Int = 0

    ): Form {
        val editText = CustomEditText(parent.context)
        editText.singleLine = true
        editText.setText(text)
        editText.hint = hint
        editText.id = id

        editText.setFocusable(false)
        editText.setClickable(false)
        editText.setOnClickListener {
            XDateTimePicker(appCompatActivity).showDateTimePicker { timePickerDialog: TimePickerDialog, day: Int, month: Int, year: Int, hour: Int, min: Int ->
                editText.setText(XUtil.getPersianDateTime(format, day, month, year, hour, min))
            }
        }

        addRowIfNotExist()
        addViewToForm(editText)
        return this
    }

    fun spinner(@ArrayRes items: Int, render: ((View, String, Int) -> Unit)? = null): Form {
        addViewToForm(CustomSpinner.withArray(parent.context, items, render))
        return this
    }

    fun spinner(items: List<Any>, render: ((View, Any, Int) -> Unit)? = null) {
        val spinner = CustomSpinner(parent.context, items, render)
        spinner.set(items)
        addViewToForm(spinner)
    }

    fun button(
        text: String,
        id: Int = 0,
        onClick: ((Button) -> Unit)? = null
    ): Form {
        val button = CustomButton(parent.context)
        button.setText(text)
        button.id = id
        button.setOnClickListener {
            onClick?.let { onClick -> onClick(it as Button) }
        }
        addRowIfNotExist()

        val buttonParent = LinearLayout(parent.context)
        buttonParent.addView(button, createLayoutParamsWrapWidth())
        buttonParent.gravity = GravityCompat.END
        addViewToForm(buttonParent)
        return this
    }

    fun checkbox(
        text: String,
        id: Int = 0,
        checked: Boolean = false
    ): Form {
        val checkBox = CustomCheckbox(parent.context)
        checkBox.text = text
        checkBox.id = id
        checkBox.setOnCheckedChangeListener(this)
        checkBox.isChecked = checked
        addViewToForm(checkBox)
        return this
    }

    fun text(
        text: String,
        id: Int = 0,
        gravity: Int = GravityCompat.START
    ): Form {
        val textView = CustomTextView(parent.context)
        textView.text = text
        textView.id = id
        textView.gravity = gravity
        textView.textColor = Color.BLACK

        addViewToForm(textView)
        return this
    }

    fun radioGroup(
        orientation: Int = LinearLayout.HORIZONTAL,
        id: Int = 0
    ): Form {
        val rg = RadioGroup(parent.context)
        rg.orientation = orientation
        rg.id = id

        addViewToForm(rg)
        return this
    }

    fun radioButton(
        text: String,
        id: Int = View.generateViewId(),
        checked: Boolean = false
    ): Form {
        val radioButton = CustomRadioButton(parent.context)
        radioButton.text = text
        radioButton.id = id
        radioButton.isChecked = checked
        radioButton.setOnCheckedChangeListener(this)

        var rg: RadioGroup? = null
        if (lastView is RadioGroup) {
            rg = lastView as RadioGroup
        } else if (lastView is RadioButton) {
            val radioParent = (lastView as RadioButton).parent
            if (radioParent is RadioGroup) {
                rg = (lastView as RadioButton).parent as RadioGroup
            }
        }

        if (rg != null) {
            addRadioButtonToRadioGroup(rg, radioButton)
        } else {
            addViewToForm(radioButton)
        }

        return this
    }

    private fun addRadioButtonToRadioGroup(rg: RadioGroup, radioButton: RadioButton) {
        if (rg.orientation == LinearLayout.VERTICAL) {
            rg.addView(radioButton, createLayoutParamsMatchWidth())
        } else if (rg.orientation == LinearLayout.HORIZONTAL) {
            rg.addView(radioButton, createLayoutParams(1F))
        }
        lastView = radioButton
    }

    private fun addRowIfNotExist() {
        if (currentRow == null) {
            row()
        }
    }

    fun row(): Form {
        currentRow = LinearLayout(parent.context)
        currentRow!!.orientation = LinearLayout.HORIZONTAL
        parent.addView(
            currentRow,
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        return this
    }

    fun depends(
        depends: Int,
        visibIfAvail: Int = View.VISIBLE,
        visibIfNotAvail: Int = View.INVISIBLE
    ): Form {
        return depends(arrayListOf(depends), visibIfAvail, visibIfNotAvail)
    }

    fun depends(
        depends: List<Int>,
        visibIfAvail: Int = View.VISIBLE,
        visibIfNotAvail: Int = View.INVISIBLE
    ): Form {
        if (lastView != null && lastView!!.id != 0) {
            dependencies.add(Dependency(depends, lastView!!.id, visibIfAvail, visibIfNotAvail))
        } else {
            throw IllegalStateException("last view cannot be found")
        }
        return this
    }

    fun space(): Form {
        val space = Space(parent.context)
        addRowIfNotExist()
        currentRow!!.addView(space, createLayoutParams(1F))
        return this
    }

    private fun createLayoutParams(weight: Float): LinearLayout.LayoutParams {
        return LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, weight)
    }

    private fun createLayoutParamsWrapWidth(): LinearLayout.LayoutParams {
        return LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
    }

    private fun createLayoutParamsMatchWidth(): LinearLayout.LayoutParams {
        return LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onCheckedChanged(button: CompoundButton?, b: Boolean) {
        if (!done) {
            return
        }
        for (dep in dependencies) {
            for (master in dep.masters) {
                if (button != null) {
                    if (master == button.id) {
                        //this view is master of someone

                        checkDependency(dep)
                    }
                } else {
                    return
                }
            }
        }
    }

    private fun checkDependency(dep: Dependency) {
        if (dependenciesSatisfied(dependencies, dep.slave)) {
            parent.findViewById<View>(dep.slave).visibility = dep.visibIfAvail
        } else {
            parent.findViewById<View>(dep.slave).visibility = dep.visibIfNotAvail
        }
    }

    private fun dependenciesSatisfied(dependencies: ArrayList<Dependency>, slaveId: Int): Boolean {
        for (dep in dependencies) {
            if (dep.slave == slaveId) { //maybe multiple slaves...
                for (master in dep.masters) {
                    if (!isSatisfied(parent.findViewById(master), slaveId)) {
                        return false
                    }
                }
            }
        }

        return true
    }

    protected open fun isSatisfied(masterView: View, slaveId: Int): Boolean {
        if (masterView is CompoundButton) {
            return masterView.isChecked
        }
        return false
    }

    fun finish() {
        if (done) {
            return
        }
        done = true
        for (i in 0 until parent.childCount) {
            val viewGroup = parent.getChildAt(i) as ViewGroup
            for (rowChildI in 0 until viewGroup.childCount) {
                validateViews(viewGroup.getChildAt(rowChildI))
            }
        }
        refreshDependencies()
    }

    public fun refreshDependencies() {
        for (dep in dependencies) {
            checkDependency(dep)
        }
    }

    open fun validateViews(view: View) {
        if (view is RadioGroup) {
            (view.getChildAt(0) as RadioButton).isChecked = true
        }
    }

    fun addViewToForm(view: View) {
        currentRow!!.addView(view, createLayoutParams(1F))
        lastView = view
    }

    private data class Dependency(
        val masters: List<Int>,
        val slave: Int,
        val visibIfAvail: Int,
        val visibIfNotAvail: Int
    )
}