package com.example.afinal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class OrderViewModelFactory(private val Plates: Int,private  val shop:String,private val dish:String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OrderViewModel::class.java)) {
            return OrderViewModel(Plates,shop,dish) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}