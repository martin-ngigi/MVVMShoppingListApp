package com.example.mvvmshoppinglistapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmshoppinglistapp.data.db.enties.ShoppingItem

@Dao
interface ShoppingDao {

    //mix of updates and inserts
    //if item is not available, it will be inserted.. but if its already existing.  It will be updated
    @Insert(onConflict = OnConflictStrategy.REPLACE) //whenever there is an insert, replace the existing id
    suspend fun upsert(item: ShoppingItem)

    /**
     * delete
     * suspend is  cuorotine
     */
    @Delete
    suspend fun delete(item: ShoppingItem)

    /**
     * shopping_items is the table name.. same as the one in the models
     */
    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>


}