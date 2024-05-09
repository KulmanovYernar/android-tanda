package domain.backet

import domain.backet.models.BacketItemModel
import domain.backet.models.BacketProductsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tandapp.domain.event.Event
import tandapp.utillibrary.ProductModel

class BacketRepositoryImpl(private val service: BacketService):BacketRepository {

    override suspend fun getProductsForBacket() = flow {
        emit(Event.loading())

        val response = service.getBacket()

        if (response.isSuccessful) emit(Event.success(response.body()))
        else emit(Event.error(response.message()))
    }

    override suspend fun addProductToBacket(backet: BacketItemModel) = flow {
        emit(Event.loading())

        val response = service.addProductToBacket(backet)

        if (response.isSuccessful) emit(Event.success(response.body()))
        else emit(Event.error(response.message()))
    }


    override suspend fun deleteProduct(id: Int) = flow {
        emit(Event.loading())

        val response = service.deleteProduct(id)

        if (response.isSuccessful) emit(Event.success(response.body()))
        else emit(Event.error(response.message()))
    }

}