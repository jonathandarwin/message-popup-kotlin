package com.jonathandarwin.message_popup_kotlin

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_login.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
    }

    private fun setListener(){
        btn_toast.setOnClickListener(this)
        btn_text.setOnClickListener(this)
        btn_snackbar.setOnClickListener(this)
        btn_dialog.setOnClickListener(this)
        btn_custom_dialog.setOnClickListener(this)
        btn_bottom_sheet_dialog.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v?.id){
            // Toast
            btn_toast.id -> {
                Toast.makeText(this, resources.getString(R.string.message_login_invalid), Toast.LENGTH_SHORT).show()
            }

            // Text
            btn_text.id -> {
                tv_message.visibility = when(tv_message.visibility){
                    View.VISIBLE -> View.GONE
                    else -> View.VISIBLE
                }
            }

            // Snackbar
            btn_snackbar.id -> {
                Snackbar.make(ll_container, resources.getString(R.string.message_login_invalid), Snackbar.LENGTH_SHORT)
                        .show()
            }

            // Dialog
            btn_dialog.id -> {
                AlertDialog.Builder(this)
                            .setTitle(resources.getString(R.string.title_message_login_invalid))
                            .setMessage(resources.getString(R.string.message_login_invalid))
                            .show()
            }

            // Custom Dialog
            btn_custom_dialog.id -> {
                val dialog = Dialog(this)
                dialog.setContentView(R.layout.dialog_login)
                dialog.show()

                dialog.btn_ok.setOnClickListener{
                    dialog.dismiss()
                }
            }

            // Bottom Sheet Dialog
            btn_bottom_sheet_dialog.id -> {
                val dialog = BottomSheetDialog(this)
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog.setContentView(R.layout.bottom_sheet_dialog_login)
                dialog.show()
            }
        }
    }
}
