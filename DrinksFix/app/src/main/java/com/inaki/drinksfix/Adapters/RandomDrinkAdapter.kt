package com.inaki.drinksfix.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inaki.drinksfix.Model.Drink
import com.inaki.drinksfix.R
import kotlinx.android.synthetic.main.drinks_recycler.view.*


class RandomDrinkAdapter(private val mCtx: Context, private val drinksList: Drink) :
    RecyclerView.Adapter<RandomDrinkAdapter.DrinkViewHolder>() {

    class DrinkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id = itemView.tv_id!!
        var name = itemView.tv_name!!
        var glass = itemView.tv_glass!!
        var category = itemView.tv_category!!
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DrinkViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.drinks_recycler, p0, false)
        return DrinkViewHolder(view)
    }

    override fun getItemCount(): Int {
        return drinksList.drinks.size
    }

    override fun onBindViewHolder(drinkViewHolder: DrinkViewHolder, p1: Int) {
        drinkViewHolder.category.text = drinksList.drinks[p1].strCategory
        drinkViewHolder.name.text = drinksList.drinks[p1].strDrink
        drinkViewHolder.id.text = drinksList.drinks[p1].idDrink
        drinkViewHolder.glass.text = drinksList.drinks[p1].strGlass
    }
}