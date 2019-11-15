package com.tpa.xuiframwork.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tpa.xuiframework.fragment.BaseFragment
import com.tpa.xuiframework.webservice.xRequestAbs
import com.tpa.xuiframework.webservice.xRequestDataAbs
import com.tpa.xuiframwork.R
import com.tpa.xuiframwork.entity.ServerResponse
import kotlinx.android.synthetic.main.fragment_data.*

class DataFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnGetReq.setOnClickListener {
            xRequestAbs("http://date.jsontest.com/")
                .startRaw({
                    textResponse.setText(it)
                }, {

                })
        }

        btnGetReqJsonObject.setOnClickListener {
            xRequestAbs("http://date.jsontest.com/").startDeserializer({
                textResponse.setText(it.toString())
            })
        }

        btnGetReqDataObject.setOnClickListener {
            val xReqData = xRequestDataAbs("http://date.jsontest.com/")
            xReqData.bodyParam("name", "val")
            xReqData.startData<ServerResponse>(
                    {
                        textResponse.setText(it.toString())
                    }, {

                    })
        }


    }
}