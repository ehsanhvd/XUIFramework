package com.tpa.xuiframework.utils

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.tpa.xuiframework.R
import com.tpa.xuiframework.XUtil
import org.jetbrains.anko.textColor

class Dialogs() {


    companion object {

        val DIALOG_STYLE = R.style.DialogTheme

        fun ask(context: Context, title: String, body: String, okListener: ((Dialog) -> Unit)) : Dialog{

            return ask(context, title, body, "", "", okListener)
        }

        fun ask(
            context: Context,
            title: String,
            body: String,
            positiveText: String,
            negativeText: String,
            okListener: ((Dialog) -> Unit)
        ) : Dialog {

            val askDialog = Dialog(context, DIALOG_STYLE)
            askDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            askDialog.setContentView(R.layout.ask_dialog)
            val acceptButton = askDialog.findViewById(R.id.btnAccept) as Button
            val negativeButton = askDialog.findViewById(R.id.btnCancel) as Button
            val texTitle = askDialog.findViewById(R.id.texTitle) as TextView
            val textBody = askDialog.findViewById(R.id.textBody) as TextView

            if (!positiveText.isEmpty()){
                acceptButton.text = positiveText
            }
            if (!negativeText.isEmpty()){
                negativeButton.text = negativeText
            }

            acceptButton.textColor = XUtil.getAccentColor(context)
            negativeButton.textColor = XUtil.getAccentColor(context)

            acceptButton.setOnClickListener { v ->
                okListener(askDialog)
            }
            texTitle.text = title
            textBody.text = body

            negativeButton.setOnClickListener { askDialog.dismiss() }
            return askDialog
        }

        fun alert(
            context: Context,
            title: String,
            body: String,
            positiveText: String = "OK",
            okListener: ((Dialog) -> Unit)
        ) : Dialog {

            val askDialog = Dialog(context, DIALOG_STYLE)
            askDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            askDialog.setContentView(R.layout.alert_dialog)
            val acceptButton = askDialog.findViewById(R.id.btnAccept) as Button
            val texTitle = askDialog.findViewById(R.id.texTitle) as TextView
            val textBody = askDialog.findViewById(R.id.textBody) as TextView

            if (!positiveText.isEmpty()){
                acceptButton.text = positiveText
            }

            acceptButton.textColor = XUtil.getAccentColor(context)

            acceptButton.setOnClickListener { v ->
                okListener(askDialog)
            }
            texTitle.text = title
            textBody.text = body

            return askDialog
        }



    }

}