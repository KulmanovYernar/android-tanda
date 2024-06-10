package domain.catalog

import tandapp.utillibrary.ProductModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService {

    @GET("product/get_products")
    suspend fun getProducts(
        @Query("category") category: String,
        @Query("subCategory") subCategory: String,
        @Query("color") color: String,
        @Query("brand") brand: String,
        @Query("productSize") productSize: String,
        @Query("page") page: String,
    ): Response<List<ProductModel>>

    @GET("product/get_products_preview")
    suspend fun getProductsPreview(): Response<List<ProductModel>>

    @GET("product/get_product/{id}")
    suspend fun getProduct(@Path("id") id: Int): Response<ProductModel>

    @GET("product/wish/{productId}")
    suspend fun addProductToWishList(@Path("productId") productId: Int): Response<Unit>


    @GET("product/get_image/{id}")
    suspend fun getImage(@Path("id") id:Int): Response<Unit>
}