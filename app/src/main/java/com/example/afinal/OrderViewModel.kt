package com.example.afinal

import androidx.lifecycle.ViewModel

class OrderViewModel(Plates:Int,shop:String,dish:String): ViewModel()
{
    var score = Plates
    var shopName:String= shop
    var dishName: String= dish
}