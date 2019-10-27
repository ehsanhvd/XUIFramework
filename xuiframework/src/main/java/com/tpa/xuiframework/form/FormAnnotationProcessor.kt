package com.tpa.xuiframework.form

import com.tpa.xuiframework.form.annotation.Input
import com.tpa.xuiframework.form.annotation.IranTelInput
import com.tpa.xuiframework.form.annotation.KeepRow
import java.lang.reflect.Field

class FormAnnotationProcessor(val form: Form, val entity: Any) {
    init {
        val fields = entity.javaClass.declaredFields


        for (i in 0 until fields.size) {
            val m = fields[i]
            var lastRow = false

            if (m.isAnnotationPresent(Input::class.java)) {
                val ta = m.getAnnotation(Input::class.java)
                val keepRow = m.isAnnotationPresent(KeepRow::class.java)

                if (0 < i && !keepRow) {
                    form.row()
                }

                editText(m, ta)
            } else if (m.isAnnotationPresent(IranTelInput::class.java)) {
                val ta = m.getAnnotation(IranTelInput::class.java)
                val keepRow = m.isAnnotationPresent(KeepRow::class.java)

                if (0 < i && !keepRow) {
                    form.row()
                }

                iranTelInput(m, ta)
            }

        }

    }

    private fun editText(m: Field, ta: Input) {
        form.editText(
            text = getValue(entity, m).toString(),
            hint = ta.displayName,
            inputType = ta.inputType,
            imeOpt = ta.imeOpt,
            maxLength = ta.maxLenght
        )
    }


    private fun iranTelInput(m: Field, ta: IranTelInput) {
        form.iranTelInput(ta.displayName, getValue(entity, m).toString(), ta.imeOpt)
    }


    private fun getValue(entity: Any, field: Field): Any? {
        field.setAccessible(true)
        return field.get(entity)
    }
}