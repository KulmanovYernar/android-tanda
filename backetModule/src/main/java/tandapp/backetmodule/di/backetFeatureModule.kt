package tandapp.backetmodule.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tandapp.backetmodule.viewmodels.BacketViewModel

val backetFeatureModule = module {

    viewModel {
        BacketViewModel(productRepository = get(),
            backetRepository = get())
    }
}