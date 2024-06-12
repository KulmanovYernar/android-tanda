package tandapp.backetmodule.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.backet.BacketRepository
import domain.backet.models.BacketItemModel
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

    val isLoading = mutableStateOf(false)

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
            backetRepository.getProductsForBasket()
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

    fun addProductToBacket(id: Int) {
        viewModelScope.launch {
            backetRepository.addProductToBasket(BacketItemModel(id))
                .flowOn(Dispatchers.IO)
                .collect {
                    isLoading.value = it.isLoading()
                    it.onSuccess {
                        getProducts()
                    }
                }
        }
    }

    fun decreaseItem(id: Int) {
        viewModelScope.launch {
            backetRepository.decreaseBasket(id)
                .flowOn(Dispatchers.IO)
                .collect {
                    isLoading.value = it.isLoading()
                    it.onSuccess {
                        getProducts()
                    }
                }
        }
    }
}