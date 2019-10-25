package com.tpa.xuiframework.form

import java.lang.reflect.Field

class FormAnnotationProcessor(val form: Form, val entity: Any) {
    init {
        val fields = entity.javaClass.declaredFields
        for (m in fields) {
            if (m.isAnnotationPresent(Input::class.java)) {
                val ta = m.getAnnotation(Input::class.java)

                editText(m, ta)
            }
        }

    }

    private fun editText(m: Field, ta: Input){
        form.editText(
            text = getValue(entity, m).toString(),
            hint = ta.displayName,
            inputType = ta.inputType,
            imeOpt = ta.imeOpt,
            maxLength = ta.maxLenght
        )
    }


    private fun getValue(entity: Any, field: Field): Any? {
        field.setAccessible(true)
        return field.get(entity)
    }
}