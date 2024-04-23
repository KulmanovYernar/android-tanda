package domain.catalog

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ProductService {
    @POST("product/add_product")
    suspend fun addProduct(): Response<Unit>

    @GET("product/get_products_preview")
    suspend fun getProductsPreview(): Response<Unit>

    @GET("product/get_product")
    suspend fun getProduct(@Query("id") id:Int): Response<Unit>
}