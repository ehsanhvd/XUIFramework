package com.tpa.xuiframework.form

import android.graphics.Color
import android.support.v4.view.GravityCompat
import android.text.InputFilter
import android.text.InputType
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import android.widget.Space
import com.tpa.xuiframework.view.CustomButton
import com.tpa.xuiframework.view.CustomCheckbox
import com.tpa.xuiframework.view.CustomEditText
import com.tpa.xuiframework.view.CustomTextView
import org.jetbrains.anko.singleLine
import org.jetbrains.anko.textColor
import java.lang.reflect.Field


class Form {

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

        private fun getValue(entity: Any, field: Field): Any? {
            field.setAccessible(true)
            return field.get(entity)
        }
    }

    class Builder(val parent: LinearLayout) {

        var currentRow: LinearLayout? = null;

        fun editText(
            hint: String = "",
            text: String = "",
            maxLength: Int = 50,
            inputType: Int = InputType.TYPE_CLASS_TEXT,
            imeOpt: Int = EditorInfo.IME_ACTION_NEXT,
            id: Int = 0

        ): Builder {
            val editText = CustomEditText(parent.context)
            editText.singleLine = true
            editText.setText(text)
            editText.hint = hint
            editText.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
            editText.inputType = inputType
            editText.imeOptions = imeOpt
            editText.id = id

            addRowIfNotExist()
            currentRow!!.addView(editText, createLayoutParams(1F))
            return this
        }

        fun button(
            text: String,
            id: Int = 0
        ): Builder {
            val button = CustomButton(parent.context)
            button.setText(text)
            button.id = id

            addRowIfNotExist()

            val buttonParent = LinearLayout(parent.context)
            buttonParent.addView(button, createLayoutParams())
            buttonParent.gravity = GravityCompat.END
            currentRow!!.addView(buttonParent, createLayoutParams(1F))
            return this
        }

        fun checkbox(
            text: String,
            id: Int = 0
        ): Builder {
            val checkBox = CustomCheckbox(parent.context)
            checkBox.text = text
            checkBox.id = id

            currentRow!!.addView(checkBox, createLayoutParams(1F))
            return this
        }

        fun text(
            text: String,
            id: Int = 0,
            gravity: Int = GravityCompat.START
        ): Builder {
            val textView = CustomTextView(parent.context)
            textView.text = text
            textView.id = id
            textView.gravity = gravity
            textView.textColor = Color.BLACK

            currentRow!!.addView(textView, createLayoutParams(1F))
            return this
        }

        private fun addRowIfNotExist() {
            if (currentRow == null) {
                row()
            }
        }

        fun row(): Builder {
            currentRow = LinearLayout(parent.context)
            currentRow!!.orientation = LinearLayout.HORIZONTAL
            parent.addView(
                currentRow,
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            return this
        }

        fun space(): Builder {
            val space = Space(parent.context)
            addRowIfNotExist()
            currentRow!!.addView(space, createLayoutParams(1F))
            return this
        }

        private fun createLayoutParams(weight: Float): LinearLayout.LayoutParams {
            return LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, weight)
        }

        private fun createLayoutParams(): LinearLayout.LayoutParams {
            return LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }
    }
}