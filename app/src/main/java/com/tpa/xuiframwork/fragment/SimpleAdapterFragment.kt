package com.tpa.xuiframwork.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tpa.xuiframework.adapter.XAdapter
import com.tpa.xuiframework.extention.loadImage
import com.tpa.xuiframework.extention.setText
import com.tpa.xuiframework.extention.showSnackbar
import com.tpa.xuiframework.fragment.XFragment
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.entity.TestData

class SimpleAdapterFragment : XFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_simple_adapter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf(
            TestData("item 1", "https://picsum.photos/200?random=1"),
            TestData("item 2", "https://picsum.photos/200?random=2"),
            TestData("item 3", "https://picsum.photos/200?random=3"),
            TestData("item 4", "https://picsum.photos/200?random=4"),
            TestData("item 5", "https://picsum.photos/200?random=5"),
            TestData("item 6", "https://picsum.photos/200?random=6"),
            TestData("item 7", "https://picsum.photos/200?random=7"),
            TestData("item 8", "https://picsum.photos/200?random=8"),
            TestData("item 9", "https://picsum.photos/200?random=9"),
            TestData("item 10", "https://picsum.photos/200?random=10"),
            TestData("item 11", "https://picsum.photos/200?random=11"),
            TestData("item 12", "https://picsum.photos/200?random=12"),
            TestData("item 13", "https://picsum.photos/200?random=13")
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter =
            XAdapter(R.layout.row_list_test, list) { view, item, i ->
                view.setText(R.id.textTitle, item.name)
                view.loadImage(R.id.imageProfile, item.profile)

                view.setOnClickListener {
                    showSnackbar("${item.name} clicked")
                }
            }

    }
}