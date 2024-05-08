package domain.catalog

import tandapp.utillibrary.ProductModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("product/get_products_preview")
    suspend fun getProductsPreview(): Response<List<ProductModel>>

    @GET("product/get_product/{id}")
    suspend fun addProduct(@Path("id") id: Int): Response<Unit>


    @GET("product/get_image/{id}")
    suspend fun getProduct(@Path("id") id:Int): Response<Unit>
}