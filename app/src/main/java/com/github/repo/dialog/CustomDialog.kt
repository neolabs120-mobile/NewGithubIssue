package com.github.repo.dialog

import android.app.Dialog
import android.content.Context
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import com.github.repo.R
import com.github.repo.retrofit.GetGihubIssueCallback


class CustomDialog(private val context: Context) {
    fun callFunction() {
        val callback = context as GetGihubIssueCallback

        val dlg = Dialog(context)

        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dlg.setContentView(R.layout.custom_dialog)

        dlg.show()

        val first = dlg.findViewById<View>(R.id.org) as EditText
        val second = dlg.findViewById<View>(R.id.repo) as EditText
        val okButton = dlg.findViewById<View>(R.id.ok) as Button

        okButton.setOnClickListener {
            //viewModel.getIssue(first.text.toString(), second.text.toString()
            callback.callback(first.text.toString(), second.text.toString())
            dlg.dismiss()
        }
    }
}