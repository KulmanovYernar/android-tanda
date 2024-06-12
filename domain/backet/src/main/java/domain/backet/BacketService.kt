package domain.backet

import domain.backet.models.BacketItemModel
import domain.backet.models.BacketProductsModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface BacketService {

    @POST("basket/delete/{id}")
    suspend fun deleteProduct(@Path("id") id: Int): Response<BacketProductsModel>

    @POST("basket/append")
    suspend fun addProductToBacket(@Body backet: BacketItemModel): Response<Unit>

    @GET("basket/unselect/{id}")
    suspend fun unSelectProduct(@Path("id") id: Int): Response<Unit>

    @GET("basket/select/{id}")
    suspend fun selectProduct(@Path("id") id: Int): Response<Unit>

    @GET("basket/get")
    suspend fun getBacket(): Response<BacketProductsModel>

    @GET("basket/decrease")
    suspend fun decreaseBacket(@Query("productId") productId: Int, @Query("decreaseBy") decreaseBy: Int = 1): Response<Unit>

}