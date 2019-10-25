package com.tpa.xuiframwork.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.tpa.xuiframework.adapter.XPaginationAdapter
import com.tpa.xuiframework.extention.loadImage
import com.tpa.xuiframework.extention.setText
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.entity.TestData
import com.tpa.xuiframwork.layout.AnkoAdapterRowItem

class PaginationAdapterFragment : Fragment() {
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
}