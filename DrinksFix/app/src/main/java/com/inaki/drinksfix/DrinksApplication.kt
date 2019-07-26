package com.inaki.drinksfix

import android.app.Application
import com.inaki.drinksfix.Component.ApplicationComponent
import com.inaki.drinksfix.Component.DaggerApplicationComponent
import com.inaki.drinksfix.DaggerInjection.Modules.ContextModule
import android.app.Activity

class DrinksApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    companion object {

        fun get(activity: Activity): DrinksApplication {
            return activity.application as DrinksApplication
        }

        fun getApplicationComponent(): ApplicationComponent {
            return getApplicationComponent()
        }
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
            .contextModule(ContextModule(this))
            .build()

        applicationComponent.injectApplication(this)
    }
}