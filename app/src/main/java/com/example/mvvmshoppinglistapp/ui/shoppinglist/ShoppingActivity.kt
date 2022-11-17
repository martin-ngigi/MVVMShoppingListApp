package com.example.mvvmshoppinglistapp.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmshoppinglistapp.R
import com.example.mvvmshoppinglistapp.data.adapters.AdapterShoppingItem
import com.example.mvvmshoppinglistapp.data.db.ShoppingDatabase
import com.example.mvvmshoppinglistapp.data.db.enties.ShoppingItem
import com.example.mvvmshoppinglistapp.data.repositories.ShoppingRepository
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import org.kodein.di.android.kodein

class ShoppingActivity : AppCompatActivity(), KodeinAware {

    override val kodein by  kodein()
    private val factory: ShoppingViewModelFactory by instance()
    lateinit var viewModel: ShoppingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        val adapter = AdapterShoppingItem(listOf(), viewModel)

        rv_shopping_list.layoutManager = LinearLayoutManager(this)
        rv_shopping_list.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fb_add.setOnClickListener{
            AddShoppingItemDialog(
                this,
                object : AddDialogListener{
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewModel.upsert(item)
                    }
                }
            ).show()
        }
    }
}