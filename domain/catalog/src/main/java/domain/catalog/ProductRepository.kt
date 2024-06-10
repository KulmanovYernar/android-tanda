package domain.catalog

import tandapp.utillibrary.ProductModel
import kotlinx.coroutines.flow.Flow
import tandapp.domain.event.Event

interface ProductRepository {
    suspend fun addProduct(): Flow<Event<Unit>>
    suspend fun addProductToWishList(productId: Int): Flow<Event<Unit>>

    suspend fun getProductsPreview(): Flow<Event<List<ProductModel>>>

    suspend fun getProduct(id: Int): Flow<Event<ProductModel>>
}