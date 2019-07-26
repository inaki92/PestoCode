package com.inaki.drinksfix.DaggerInjection.Modules

import android.content.Context
import com.inaki.drinksfix.Adapters.RandomDrinkAdapter
import dagger.Module
import com.inaki.drinksfix.DaggerInjection.Scopes.ActivityScope
import com.inaki.drinksfix.Model.Drink
import dagger.Provides



@Module(includes = [MainActivityContextModule::class])
class AdapterModule {

    @Provides
    @ActivityScope
    fun provideDrinksAdapter(context: Context, drink: Drink): RandomDrinkAdapter {
        return RandomDrinkAdapter(context,drink)
    }
}