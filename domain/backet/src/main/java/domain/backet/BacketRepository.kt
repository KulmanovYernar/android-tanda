package domain.backet

import domain.backet.models.BacketItemModel
import domain.backet.models.BacketProductsModel
import kotlinx.coroutines.flow.Flow
import tandapp.domain.event.Event

interface BacketRepository {
    suspend fun getProductsForBasket(): Flow<Event<BacketProductsModel>>

    suspend fun addProductToBasket(backet: BacketItemModel): Flow<Event<Unit>>

    suspend fun decreaseBasket(id: Int): Flow<Event<Unit>>

    suspend fun deleteProduct(id: Int): Flow<Event<BacketProductsModel>>

}