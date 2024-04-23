package domain.catalog

import kotlinx.coroutines.flow.Flow
import tandapp.domain.event.Event

interface ProductRepository {
    suspend fun addProduct(): Flow<Event<Unit>>

    suspend fun getProductsPreview(): Flow<Event<Unit>>

    suspend fun getProduct(id:Int): Flow<Event<Unit>>
}