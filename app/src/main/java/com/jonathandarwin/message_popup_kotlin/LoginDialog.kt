package com.jonathandarwin.message_popup_kotlin

import android.app.Dialog
import android.content.Context
import android.view.ContextMenu
import android.view.View
import kotlinx.android.synthetic.main.dialog_login.*

class LoginDialog(private val ctx : Context) : Dialog(ctx) {
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        setContentView(R.layout.dialog_login)
        btn_ok.setOnClickListener{
            dismiss()
        }
    }
}