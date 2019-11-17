package com.tpa.xuiframwork.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tpa.xuiframework.adapter.XPaginationAdapter
import com.tpa.xuiframework.extention.loadImage
import com.tpa.xuiframework.extention.setText
import com.tpa.xuiframework.fragment.XFragment
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.entity.TestData
import com.tpa.xuiframwork.layout.AnkoAdapterRowItem

class PaginationAdapterFragment : XFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pagination_adapter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewComponent = AnkoAdapterRowItem()

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val pAdapter = XPaginationAdapter(
            viewComponent,
            R.layout.row_loading,
            recyclerView,
            { adapter, lastIndex ->

                //on reached last item do network request
                Handler().postDelayed({
                    adapter.addItems(getList())
                }, 2000)
            }, { v: View, item: TestData, i : Int ->
                v.setText(R.id.textTitle, item.name)
                v.loadImage(R.id.imageProfile, item.profile)
            }
        )

        recyclerView.adapter = pAdapter
        pAdapter.addItems(getList())
    }

    private fun getList(): List<TestData> = arrayListOf(
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
}