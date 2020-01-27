package com.tpa.xuiframework.utils

import android.app.Dialog
import android.content.Context
import android.graphics.PorterDuff
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.StringRes
import com.hvd.xcore.XUtil
import com.tpa.xuiframework.R
import org.jetbrains.anko.textColor

class Dialogs() {


    companion object {

        public val DIALOG_STYLE = R.style.DialogTheme

        fun ask(
            context: Context,
            @StringRes title: Int,
            @StringRes body: Int,
            @StringRes positiveText: Int,
            @StringRes negativeText: Int,
            okListener: ((Dialog) -> Unit)
        ): Dialog {
            return ask(
                context, context.getString(title),
                context.getString(body),
                context.getString(positiveText),
                context.getString(negativeText),
                okListener
            )
        }

        fun ask(
            context: Context,
            title: String,
            body: String,
            positiveText: String = context.getString(R.string.ok),
            negativeText: String = context.getString(R.string.cancel),
            okListener: ((Dialog) -> Unit)
        ): Dialog {

            val askDialog = Dialog(context, DIALOG_STYLE)
            askDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            askDialog.setContentView(R.layout.ask_dialog)
            val acceptButton = askDialog.findViewById(R.id.btnAccept) as Button
            val negativeButton = askDialog.findViewById(R.id.btnCancel) as Button
            val texTitle = askDialog.findViewById(R.id.texTitle) as TextView
            val textBody = askDialog.findViewById(R.id.textBody) as TextView

            if (!positiveText.isEmpty()) {
                acceptButton.text = positiveText
            }
            if (!negativeText.isEmpty()) {
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
            @StringRes title: Int,
            @StringRes body: Int,
            @StringRes positiveText: Int = R.string.ok,
            okListener: ((Dialog) -> Unit)
        ): Dialog {
            return alert(
                context,
                context.getString(title),
                context.getString(body),
                context.getString(positiveText),
                okListener
            )
        }

        fun alert(
            context: Context,
            title: String,
            body: String,
            positiveText: String = context.getString(R.string.ok),
            okListener: ((Dialog) -> Unit)
        ): Dialog {

            val askDialog = Dialog(context, DIALOG_STYLE)
            askDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            askDialog.setContentView(R.layout.alert_dialog)
            val acceptButton = askDialog.findViewById(R.id.btnAccept) as Button
            val texTitle = askDialog.findViewById(R.id.texTitle) as TextView
            val textBody = askDialog.findViewById(R.id.textBody) as TextView

            if (!positiveText.isEmpty()) {
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

        fun inputDialog(
            context: Context,
            @StringRes title: Int,
            @StringRes defaultText: Int = 0,
            @StringRes hint: Int = 0,
            @StringRes positiveText: Int = R.string.ok,
            okListener: ((Dialog) -> Unit)
        ): Dialog {
            return inputDialog(
                context,
                context.getString(title),
                context.getString(defaultText),
                context.getString(hint),
                context.getString(positiveText),
                okListener
            )
        }

        fun inputDialog(
            context: Context,
            title: String,
            defaultText: String = "",
            hint: String = "",
            positiveText: String = context.getString(R.string.ok),
            okListener: ((Dialog) -> Unit)
        ): Dialog {

            val askDialog = Dialog(context, DIALOG_STYLE)
            askDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            askDialog.setContentView(R.layout.input_dialog)
            val acceptButton = askDialog.findViewById(R.id.btnAccept) as Button
            val texTitle = askDialog.findViewById(R.id.texTitle) as TextView
            val inputText = askDialog.findViewById(R.id.editInput) as EditText

            if (!positiveText.isEmpty()) {
                acceptButton.text = positiveText
            }

            acceptButton.textColor = XUtil.getAccentColor(context)

            acceptButton.setOnClickListener { v ->
                okListener(askDialog)
            }
            texTitle.text = title
            inputText.setText(defaultText)
            inputText.hint = hint
            inputText.getBackground().mutate().setColorFilter(XUtil.getAccentColor(context), PorterDuff.Mode.SRC_ATOP);


            return askDialog
        }

        fun getProgressDialog(context: Context, @StringRes waitingText: Int): Dialog {
            val askDialog = Dialog(context, R.style.DialogTheme)
            askDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            askDialog.setContentView(R.layout.progress_dialog)
            askDialog.findViewById<TextView>(R.id.textLabel).setText(context.getString(waitingText))
            return askDialog
        }
    }

}