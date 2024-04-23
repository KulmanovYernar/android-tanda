package domain.catalog

import kotlinx.coroutines.flow.Flow
import tandapp.domain.event.Event

class ProductRepositoryImpl(private val dataSource: ProductService) : ProductRepository {
    override suspend fun addProduct(): Flow<Event<Unit>> {
        TODO("Not yet implemented")
    }

    override suspend fun getProductsPreview(): Flow<Event<Unit>> {
        TODO("Not yet implemented")
    }

    override suspend fun getProduct(id: Int): Flow<Event<Unit>> {
        TODO("Not yet implemented")
    }

}