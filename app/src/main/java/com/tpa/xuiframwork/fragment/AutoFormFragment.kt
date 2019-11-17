package com.tpa.xuiframwork.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.tpa.xuiframework.form.Form
import com.tpa.xuiframework.fragment.XFragment
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.entity.Person
import kotlinx.android.synthetic.main.auto_form_fragment.*

class AutoFormFragment : XFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.auto_form_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val person = Person("name")

        val form = Form.with(activity as AppCompatActivity, linForm, person)

        btnValidate.setOnClickListener {
            form.validateForm { editText: EditText, isValid: Boolean ->
                if (!isValid) {
                    editText.setError("error")
                }
            }
        }

        btnPopulate.setOnClickListener {
            println("before populate: $person")
            form.populateToEntity()
            println("after populate: $person")
        }
    }
}