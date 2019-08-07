package com.tpa.xuiframwork.activity

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.tpa.xuiframework.activity.XActivity
import com.tpa.xuiframework.adapter.PaginationAdapter
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.entity.TestData


class MainActivity : XActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val list = arrayListOf(
            TestData("item 1", "https://pickaface.net/gallery/avatar/Benjohnsone54fbec7a167c5.png"),
            TestData("item 2"),
            TestData("item 3"),
            TestData("item 4"),
            TestData("item 5"),
            TestData("item 6"),
            TestData("item 7"),
            TestData("item 8"),
            TestData("item 9"),
            TestData("item 10"),
            TestData("item 11"),
            TestData("item 12"),
            TestData("item 13")
        )

//        recyclerView.adapter =
//            XAdapter(R.layout.row_list_test, list) { view, item ->
//
//            }

        recyclerView.adapter =
            PaginationAdapter(
                R.layout.row_list_test_binding,
                R.layout.row_loading,
                recyclerView, { paginationAdapter: PaginationAdapter<TestData>, i: Int ->
                    paginationAdapter.loading = false
                    //or you can use paginationAdapter.addItem(items)
                }
            )


//        XRequest("gettravels")
//            .addParam("limit", 10)
//            .addParam("skip", 0)
//            .addParam("version", 3)
//            .start {
//                println(it)
//            }
    }

}