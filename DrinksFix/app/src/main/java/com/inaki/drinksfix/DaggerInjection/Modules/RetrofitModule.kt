package com.inaki.drinksfix.DaggerInjection.Modules

import com.inaki.drinksfix.DaggerInjection.Scopes.ApplicationScope
import com.inaki.drinksfix.Network.DrinkService
import com.inaki.drinksfix.Util.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {

    @Provides
    @ApplicationScope
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @ApplicationScope
    fun provideDrinkService(retrofit: Retrofit): DrinkService {
        return retrofit.create(DrinkService::class.java)
    }
}