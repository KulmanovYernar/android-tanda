package domain.backet

import domain.backet.models.BacketItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface BacketService {

    @POST("backet/delete/{id}")
    suspend fun deleteProduct(@Path("id") id: Int): Response<Unit>

    @POST("backet/append")
    suspend fun addProductToBacket(@Body backet: BacketItem): Response<Unit>

    @GET("backet/unselect/{id}")
    suspend fun unSelectProduct(@Path("id") id: Int): Response<Unit>

    @GET("backet/select/{id}")
    suspend fun selectProduct(@Path("id") id: Int): Response<Unit>

    @GET("backet/get")
    suspend fun getBacket(): Response<Unit> // TODO add Model

    @GET("backet/decrease")
    suspend fun decreaseBacket(@Query("productId") productId: Int, @Query("decreaseBy") decreaseBy: Int): Response<Unit>

}