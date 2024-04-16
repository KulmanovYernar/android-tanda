package tandapp.homemodule.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tandapp.homemodule.viewmodels.HomeViewModel

val homeFeatureModule = module {
    viewModel {
        HomeViewModel()
    }
}