package tandapp.backetmodule.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.catalog.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import tandapp.utillibrary.ProductModel

class BacketViewModel(
    private val productRepository: ProductRepository,
) : ViewModel() {

    val products: MutableState<List<ProductModel>?> = mutableStateOf(null)

    init {
        getProductsPreview()
    }

    fun getProductsPreview() {
        viewModelScope.launch {
            productRepository.getProductsPreview()
                .flowOn(Dispatchers.IO)
                .collect {
                    it.onSuccess {
                        val result = it
                        products.value = result
                    }
                }
        }
    }
}