package com.example.mvvmshoppinglistapp.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.mvvmshoppinglistapp.data.db.enties.ShoppingItem
import com.example.mvvmshoppinglistapp.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
): ViewModel() {
    /**
     * Dispatcher.main is the context of the main thread/coutine
     */

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}