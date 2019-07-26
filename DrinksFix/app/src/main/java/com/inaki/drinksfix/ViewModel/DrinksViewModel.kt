package com.inaki.drinksfix.ViewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.inaki.drinksfix.Model.Drink
import com.inaki.drinksfix.Network.DrinkService
import com.inaki.drinksfix.Util.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DrinksViewModel: ViewModel() {
    private var randomDrink: MutableLiveData<Drink>? = null

    private var compositeDisposable: CompositeDisposable? = null


    @Inject lateinit var schedulerProvider: SchedulerProvider
    @Inject lateinit var drinkService: DrinkService

    val randDrink: LiveData<Drink>
        get() { if (randomDrink == null) {
            randomDrink = MutableLiveData()
            loadRdmDrink()
        }
            return randomDrink!!
        }

    private fun loadRdmDrink() {
        compositeDisposable!!.add(drinkService.getRandomDrink()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe())
    }

    private fun handleResponse(drinksList: Drink){
        randomDrink!!.value = drinksList
    }
}