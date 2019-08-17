package com.tpa.xuiframwork.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tpa.xuiframework.adapter.XAdapterBinding
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.entity.TestData

class BindingAdapterFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_binding_adapter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf(
            TestData("binded item 1", "https://pickaface.net/gallery/avatar/Benjohnsone54fbec7a167c5.png"),
            TestData("binded item 2"),
            TestData("binded item 3"),
            TestData("binded item 4"),
            TestData("binded item 5"),
            TestData("binded item 6"),
            TestData("binded item 7"),
            TestData("binded item 8"),
            TestData("binded item 9"),
            TestData("binded item 10"),
            TestData("binded item 11"),
            TestData("binded item 12"),
            TestData("binded item 13")
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter =
            XAdapterBinding(R.layout.row_list_test_binding, list)

    }
}