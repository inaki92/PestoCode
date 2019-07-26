package com.inaki.drinksfix.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.inaki.drinksfix.Adapters.RandomDrinkAdapter
import com.inaki.drinksfix.Component.MainActivityComponent
import com.inaki.drinksfix.DaggerInjection.Qualifiers.ActivityContext
import com.inaki.drinksfix.DaggerInjection.Qualifiers.ApplicationContext
import com.inaki.drinksfix.DrinksApplication
import com.inaki.drinksfix.Network.DrinkService
import com.inaki.drinksfix.R
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var drinksRecycler: RecyclerView
    lateinit var mainActivityComponent: MainActivityComponent

    @Inject lateinit var drinksAdapter: RandomDrinkAdapter
    @Inject lateinit var drinkService: DrinkService

    @Inject
    @ApplicationContext
    lateinit var context: Context

    @Inject
    @ActivityContext
    lateinit var activityContext: Context



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drinksRecycler = recycler_drinks
        drinksRecycler.setHasFixedSize(true)
        drinksRecycler.layoutManager = GridLayoutManager(context,2)

        var applicationComponent= DrinksApplication.get(this).applicationComponent

//        mainActivityComponent = DaggerMainActivityComponent.builder().
    }
}