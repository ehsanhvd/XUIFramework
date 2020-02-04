package com.tpa.xuiframwork.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hvd.xcore.extention.setText
import com.hvd.xcustomview.view.loadImage
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.entity.TestData
import kotlinx.android.synthetic.main.fragment_multiselect.*
import org.jetbrains.anko.sdk27.coroutines.onLongClick

class MultiSelectFragment : com.hvd.xcustomview.fragment.XFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_multiselect, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

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

        var pAdapter : com.hvd.xcustomview.adapter.XMultiSelectAdapter<TestData>? = null

        pAdapter = com.hvd.xcustomview.adapter.XMultiSelectAdapter(
            resId = R.layout.row_list_test,
            progressLayout = R.layout.row_loading,
            recyclerView = recyclerView
        ) { v: View, item: TestData, i, b ->
            v.onLongClick {
                pAdapter!!.invertSelection(i)
            }
            v.setText(
                R.id.textTitle, item.name + (if (b) {
                    " [selected]"
                } else {
                    ""
                })
            )
            v.loadImage(R.id.imageProfile, item.profile)
        }

        pAdapter.listFinished = true
        recyclerView.adapter = pAdapter
        pAdapter.addItems(list)
    }

    fun unselectAll(){
        (recyclerView.adapter as com.hvd.xcustomview.adapter.XMultiSelectAdapter<*>).unSelectAll()
    }
}