package com.tpa.xuiframework.form

import com.tpa.xuiframework.form.annotation.*
import java.lang.reflect.Field
import java.util.*
import kotlin.reflect.KClass


class FormAnnotationProcessor(val form: Form, val entity: Any) {
    init {
        val fields = entity.javaClass.declaredFields
        val orderedFields = arrayListOf<Field>()

        fields.forEach {
            if (it.isAnnotationPresent(Order::class.java)){
                orderedFields.add(it)
            }
        }

        orderedFields.sortWith(Comparator { lastField: Field, nextField: Field ->
            val last = lastField.getAnnotation(Order::class.java)
            val next = nextField.getAnnotation(Order::class.java)


            return@Comparator last.order.compareTo(next.order)
        })

        var i = 0
        orderedFields.forEach { m ->
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
            } else if (m.isAnnotationPresent(DatePicker::class.java)) {
                val ta = m.getAnnotation(DatePicker::class.java)
                val keepRow = m.isAnnotationPresent(KeepRow::class.java)

                if (0 < i && !keepRow) {
                    form.row()
                }

                datePicker(ta)
            }

            i++
        }
    }

    private fun editText(m: Field, ta: Input) {
        form.editText(
            text = getValue(entity, m).toString(),
            hint = ta.displayName,
            inputType = ta.inputType,
            imeOpt = ta.imeOpt,
            maxLength = ta.maxLenght,
            validator = getInstance(ta.validator)
        )
    }

    private fun iranTelInput(m: Field, ta: IranTelInput) {
        form.iranTelInput(ta.displayName, getValue(entity, m).toString(), ta.imeOpt)
    }

    private fun datePicker(ta: DatePicker) {
        form.datePicker(ta.displayName, ta.date)
    }

    private fun getValue(entity: Any, field: Field): Any? {
        field.setAccessible(true)
        return field.get(entity)
    }

    /* We have no way to guarantee that an empty constructor exists, so must return T? instead of T */
    fun <T : Any> getInstance(clazz: KClass<T>): T? {
        clazz.constructors.forEach { con ->
            if (con.parameters.size == 0) {
                return con.call()
            }
        }
        return null
    }

}