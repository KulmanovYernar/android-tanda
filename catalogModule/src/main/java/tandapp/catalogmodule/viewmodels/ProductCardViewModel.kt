package tandapp.catalogmodule.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.backet.BacketRepository
import domain.backet.models.BacketItemModel
import domain.catalog.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import tandapp.catalogmodule.models.ShoeColorModel
import tandapp.utillibrary.ProductModel

class ProductCardViewModel(
    private val productRepository: ProductRepository,
    private val backetRepository: BacketRepository,
) : ViewModel() {

    val product:MutableState<ProductModel?> = mutableStateOf(null)

    val shoesSizes = listOf<String>("36", "37", "38", "39", "40")

    val shoesColors = listOf(
        ShoeColorModel(
            id = 0,
            color = Color.Black,
            title = "Черный"
        ),
        ShoeColorModel(
            id = 1,
            color = Color.Gray,
            title = "Серый"
        ),
        ShoeColorModel(
            id = 2,
            color = Color.White,
            title = "Белый"
        )
    )

    val selectedSize: MutableState<String> = mutableStateOf(shoesSizes[0])
    val selectedColor: MutableState<Int> = mutableStateOf(shoesColors[0].id)

    val isLoading = mutableStateOf(false)

    fun getProductInfo(id:Int) {
        viewModelScope.launch {
            productRepository.getProduct(id = id)
                .flowOn(Dispatchers.IO)
                .collect {
                    isLoading.value = it.isLoading()
                    it.onSuccess {
                        val result = it
                        product.value = result
                    }
                }
        }
    }


    fun addProductToBacket(id: Int) {
        viewModelScope.launch {
            backetRepository.addProductToBasket(BacketItemModel(id))
                .flowOn(Dispatchers.IO)
                .collect {
                    it.onSuccess {
                        getProductInfo(id)
                    }
                }
        }
    }

    fun addOrDeleteItemWishList(id: Int){
        viewModelScope.launch {
            productRepository.addProductToWishList(id)
                .flowOn(Dispatchers.IO)
                .collect {
                    it.onSuccess {
                        getProductInfo(id)
                    }
                }
        }
    }
}