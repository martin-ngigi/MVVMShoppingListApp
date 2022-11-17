package com.example.mvvmshoppinglistapp.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.mvvmshoppinglistapp.R
import com.example.mvvmshoppinglistapp.data.db.enties.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_items.*

class AddShoppingItemDialog(
    context: Context,
    var addDialogListener: AddDialogListener
    ): AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_add_shopping_items)

        //handle buttons
        tv_add.setOnClickListener {
            val name = edt_name.text.toString()
            val amount = tv_amount.text.toString().toInt()
            if (name.isNullOrEmpty() || tv_amount.text.isNullOrEmpty()){
                Toast.makeText(context, "Please enter all the fields", Toast.LENGTH_SHORT)
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount)
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tv_cancel.setOnClickListener {
            cancel()
        }
    }
}