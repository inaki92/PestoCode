package com.inaki.drinksfix.DaggerInjection.Modules

import android.content.Context
import com.inaki.drinksfix.DaggerInjection.Qualifiers.ActivityContext
import dagger.Module
import com.inaki.drinksfix.DaggerInjection.Scopes.ActivityScope
import com.inaki.drinksfix.ui.MainActivity
import dagger.Provides


@Module
class MainActivityContextModule(private val mainActivity: MainActivity) {

    var context: Context = mainActivity

    @Provides
    @ActivityScope
    fun providesMainActivity(): MainActivity {
        return mainActivity
    }

    @Provides
    @ActivityScope
    @ActivityContext
    fun providesContext(): Context {
        return context
    }
}