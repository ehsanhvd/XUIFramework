package com.tpa.xuiframwork.activity

import android.os.Bundle
import android.view.View
import com.tpa.xuiframework.activity.XDrawerActivity
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.fragment.BindingAdapterFragment
import com.tpa.xuiframwork.fragment.PaginationAdapterFragment
import com.tpa.xuiframwork.fragment.SimpleAdapterFragment


class MainActivity : XDrawerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setDrawerView(R.layout.merge_drawer)


        val fragments = arrayListOf(
            SimpleAdapterFragment(),
            BindingAdapterFragment(),
            PaginationAdapterFragment()
        )

        setFragment(fragments[0], R.id.frameFragment)
        val onMenuItemClick: (View) -> Unit = {
            toggleDrawer()
            if (it.tag is String) {
                setFragment(fragments[(it.tag as String).toInt()], R.id.frameFragment)
            }
        }

        findViewById<View>(R.id.linSimpleAdapter).setOnClickListener(onMenuItemClick)
        findViewById<View>(R.id.linBindingAdapter).setOnClickListener(onMenuItemClick)
        findViewById<View>(R.id.linPaginationAdapter).setOnClickListener(onMenuItemClick)


//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
//
//        val list = arrayListOf(
//            TestData("item 1", "https://pickaface.net/gallery/avatar/Benjohnsone54fbec7a167c5.png"),
//            TestData("item 2"),
//            TestData("item 3"),
//            TestData("item 4"),
//            TestData("item 5"),
//            TestData("item 6"),
//            TestData("item 7"),
//            TestData("item 8"),
//            TestData("item 9"),
//            TestData("item 10"),
//            TestData("item 11"),
//            TestData("item 12"),
//            TestData("item 13")
//        )
//
//        recyclerView.adapter =
//            XAdapterBinding(R.layout.row_list_test_binding, list) { view, item ->
//
//            }

//        recyclerView.adapter =
//            PaginationAdapterFragment(
//                R.layout.row_list_test_binding,
//                R.layout.row_loading,
//                recyclerView, { paginationAdapter: PaginationAdapterFragment<TestData>, i: Int ->
//                    paginationAdapter.loading = false
//                    //or you can use paginationAdapter.addItem(items)
//                }
//            )


//        XRequest("gettravels")
//            .addParam("limit", 10)
//            .addParam("skip", 0)
//            .addParam("version", 3)
//            .start {
//                println(it)
//            }
    }

}