package com.tpa.xuiframwork.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tpa.xuiframework.adapter.XAdapter
import com.tpa.xuiframework.extention.loadImage
import com.tpa.xuiframework.extention.setText
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.entity.TestData

class SimpleAdapterFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_simple_adapter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter =
            XAdapter(R.layout.row_list_test, list) { view, item ->
                view.setText(R.id.textTitle, item.name)
                view.loadImage(R.id.imageProfile, item.profile)
            }

    }
}