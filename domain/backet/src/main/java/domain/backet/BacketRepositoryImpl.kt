package domain.backet

import domain.backet.models.BacketItemModel
import kotlinx.coroutines.flow.flow
import tandapp.domain.event.Event

class BacketRepositoryImpl(private val service: BacketService):BacketRepository {

    override suspend fun getProductsForBasket() = flow {
        emit(Event.loading())

        val response = service.getBacket()

        if (response.isSuccessful) emit(Event.success(response.body()))
        else emit(Event.error(response.message()))
    }

    override suspend fun addProductToBasket(backet: BacketItemModel) = flow {
        emit(Event.loading())

        val response = service.addProductToBacket(backet)

        if (response.isSuccessful) emit(Event.success(response.body()))
        else emit(Event.error(response.message()))
    }

    override suspend fun decreaseBasket(id: Int) = flow {
        emit(Event.loading())

        val response = service.decreaseBacket(productId = id)

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