package com.inaki.drinksfix.Network

import com.inaki.drinksfix.Model.Drink
import com.inaki.drinksfix.Util.RANDOM_DRINK
import io.reactivex.Observable
import retrofit2.http.GET

interface DrinkService {

    @GET(RANDOM_DRINK)
    fun getRandomDrink(): Observable<Drink>
}