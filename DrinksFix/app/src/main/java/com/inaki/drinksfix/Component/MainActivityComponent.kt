package com.inaki.drinksfix.Component

import android.content.Context
import com.inaki.drinksfix.DaggerInjection.Modules.AdapterModule
import com.inaki.drinksfix.DaggerInjection.Qualifiers.ActivityContext
import com.inaki.drinksfix.DaggerInjection.Scopes.ActivityScope
import com.inaki.drinksfix.ui.MainActivity
import dagger.Component

@ActivityScope
@Component(modules = [AdapterModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    @ActivityContext
    fun getContext(): Context
    fun injectMainActivity(mainActivity: MainActivity)
}