package domain.backet

import domain.backet.models.BacketItemModel
import domain.backet.models.BacketProductsModel
import kotlinx.coroutines.flow.Flow
import tandapp.domain.event.Event
import tandapp.utillibrary.ProductModel

interface BacketRepository {
    suspend fun getProductsForBacket(): Flow<Event<BacketProductsModel>>

    suspend fun addProductToBacket(backet: BacketItemModel): Flow<Event<Unit>>

    suspend fun deleteProduct(id: Int): Flow<Event<BacketProductsModel>>

}