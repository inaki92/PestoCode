package com.inaki.drinksfix.Component

import android.content.Context
import com.inaki.drinksfix.DaggerInjection.Modules.ContextModule
import com.inaki.drinksfix.DaggerInjection.Modules.RetrofitModule
import com.inaki.drinksfix.DaggerInjection.Scopes.ApplicationScope
import dagger.Component
import javax.inject.Singleton
import com.inaki.drinksfix.DaggerInjection.Qualifiers.ApplicationContext
import com.inaki.drinksfix.DrinksApplication
import com.inaki.drinksfix.Network.DrinkService


@Singleton
@ApplicationScope
@Component(modules = [RetrofitModule::class, ContextModule::class])
interface ApplicationComponent {

    fun getDrinkService(): DrinkService

    @ApplicationContext
    fun getContext(): Context

    fun injectApplication(application: DrinksApplication)
}