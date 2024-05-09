package tandapp.backetmodule.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.backet.BacketRepository
import domain.backet.models.BacketProductsModel
import domain.catalog.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import tandapp.utillibrary.ProductModel

class BacketViewModel(
    private val productRepository: ProductRepository,
    private val backetRepository: BacketRepository,
) : ViewModel() {

    val previewProducts: MutableState<List<ProductModel>?> = mutableStateOf(null)

    val productsForBacket: MutableState<BacketProductsModel?> = mutableStateOf(null)

    init {
        getProducts()
        getProductsPreview()
    }

    fun getProductsPreview() {
        viewModelScope.launch {
            productRepository.getProductsPreview()
                .flowOn(Dispatchers.IO)
                .collect {
                    it.onSuccess {
                        val result = it
                        previewProducts.value = result
                    }
                }
        }
    }

    fun getProducts(){
        viewModelScope.launch {
            backetRepository.getProductsForBacket()
                .flowOn(Dispatchers.IO)
                .collect{
                    it.onSuccess {
                        val result = it
                        productsForBacket.value = result
                    }
                }
        }
    }

    fun deleteProduct(id: Int){
        viewModelScope.launch {
            backetRepository.deleteProduct(id)
                .flowOn(Dispatchers.IO)
                .collect{
                    it.onSuccess {
                        productsForBacket.value = it
                    }
                }
        }
    }
}