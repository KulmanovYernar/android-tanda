package tandapp.catalogmodule.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tandapp.catalogmodule.viewmodels.ProductCardViewModel

val catalogModule = module {
    viewModel {
        ProductCardViewModel()
    }
}