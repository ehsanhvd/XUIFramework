package com.tpa.xuiframwork

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.tpa.xuiframework.adapter.XAdapterBinding
import com.tpa.xuiframwork.entity.TestData

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val list = arrayListOf(
            TestData("item 1", "https://pickaface.net/gallery/avatar/Benjohnsone54fbec7a167c5.png"),
            TestData("item 2"),
            TestData("item 3")
        )


//        recyclerView.adapter =
//            XAdapterBinding(R.layout.row_list_test, list) { view, item ->
//                view.setText(R.id.textTitle, item.name)
//                view.loadImage(R.id.imageProfile, item.profile)
//            }

        recyclerView.adapter =
            XAdapterBinding(R.layout.row_list_test_binding, list)
    }

}