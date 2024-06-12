package tandapp.profilemodule.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tandapp.profilemodule.viewmodels.ProfileViewModel

val profileFeatureModule = module {
    viewModel {
        ProfileViewModel(
            profileRepository = get(),
            productRepository = get(),
            backetRepository = get()
        )
    }
}