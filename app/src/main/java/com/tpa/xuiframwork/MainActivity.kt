package com.tpa.xuiframwork

import android.app.Activity
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.tpa.xuiframework.XAdapter
import com.tpa.xuiframework.extention.setText
import com.tpa.xuiframwork.databinding.RowListTestBinding
import com.tpa.xuiframwork.entity.TestData

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val list = arrayListOf(TestData("test1", "https://artcorgi.com/wp-content/uploads/2014/09/bored.png"),
            TestData("test2"),
            TestData("test4"),
            TestData("test5"),
            TestData("test6"),
            TestData("test7"),
            TestData("test8"),
            TestData("test9")
        );

        recyclerView.adapter =
            XAdapter(R.layout.row_list_test, list) { view, item ->
//                view.setText(R.id.textTitle, item.name)
            }
    }

}