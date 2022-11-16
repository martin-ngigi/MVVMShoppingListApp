package com.example.mvvmshoppinglistapp.data.db.enties

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items") //make kotlin know that this is an entity in he db
data class ShoppingItem (
    @ColumnInfo(name= "item_name")
    var name: String,
    @ColumnInfo(name= "item_amount")
    var amount: Int
){
    @PrimaryKey(autoGenerate = true) //kotlin will generate automatically
    var id: Int? = null
}