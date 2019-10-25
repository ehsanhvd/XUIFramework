package com.tpa.xuiframwork.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tpa.xuiframework.adapter.XMultiSelectAdapter
import com.tpa.xuiframework.extention.loadImage
import com.tpa.xuiframework.extention.setText
import com.tpa.xuiframework.fragment.BaseFragment
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.entity.TestData
import kotlinx.android.synthetic.main.fragment_multiselect.*
import org.jetbrains.anko.sdk27.coroutines.onLongClick

class MultiSelectFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_multiselect, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

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

        var pAdapter : XMultiSelectAdapter<TestData>? = null

        pAdapter = XMultiSelectAdapter(
            resId = R.layout.row_list_test,
            progressLayout = R.layout.row_loading,
            recyclerView = recyclerView
        ) { v: View, item: TestData, i, b ->
            v.onLongClick {
                pAdapter!!.invertSelection(i)
            }
            v.setText(R.id.textTitle, item.name + (if (b) {" [selected]"} else {""}))
            v.loadImage(R.id.imageProfile, item.profile)
        }

        pAdapter.listFinished = true
        recyclerView.adapter = pAdapter
        pAdapter.addItems(list)
    }

    fun unselectAll(){
        (recyclerView.adapter as XMultiSelectAdapter<*>).unSelectAll()
    }
}