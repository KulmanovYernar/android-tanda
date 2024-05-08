package domain.catalog

import tandapp.utillibrary.ProductModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tandapp.domain.event.Event

class ProductRepositoryImpl(private val dataSource: ProductService) : ProductRepository {
    override suspend fun addProduct(): Flow<Event<Unit>> {
        TODO("Not yet implemented")
    }

    override suspend fun getProductsPreview(): Flow<Event<List<tandapp.utillibrary.ProductModel>>> = flow {
        emit(Event.loading())

        val response = dataSource.getProductsPreview()

        if (response.isSuccessful) emit(Event.success(response.body()))
        else emit(Event.error(response.message()))
    }

    override suspend fun getProduct(id: Int): Flow<Event<Unit>> {
        TODO("Not yet implemented")
    }

}