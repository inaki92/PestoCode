package com.inaki.drinksfix.Model


import com.google.gson.annotations.SerializedName

data class Drink(
    @SerializedName("drinks")
    val drinks: List<DrinkDetails>
)