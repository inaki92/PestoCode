package com.inaki.drinksfix.DaggerInjection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.inaki.drinksfix.ViewModel.DrinksViewModel
import com.inaki.drinksfix.ViewModel.ViewModelFactory
import com.inaki.drinksfix.ViewModel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DrinksViewModel::class) // PROVIDE YOUR OWN MODELS HERE
    internal abstract fun bindEditPlaceViewModel(drinksViewModel: DrinksViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}