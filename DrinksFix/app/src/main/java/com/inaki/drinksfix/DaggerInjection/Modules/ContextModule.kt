package com.inaki.drinksfix.DaggerInjection.Modules

import android.content.Context
import com.inaki.drinksfix.DaggerInjection.Qualifiers.ApplicationContext
import dagger.Module
import com.inaki.drinksfix.DaggerInjection.Scopes.ApplicationScope
import dagger.Provides



@Module
class ContextModule(private val context: Context) {

    @Provides
    @ApplicationScope
    @ApplicationContext
    fun provideContext(): Context {
        return  context
    }
}