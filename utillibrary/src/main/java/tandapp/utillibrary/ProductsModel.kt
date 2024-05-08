package tandapp.utillibrary

import androidx.annotation.Keep

@Keep
data class ProductsModel(
    val products: List<ProductModel>
)


@Keep
data class ProductModel(
    val id: Int?,
    val title: String?,
    val brand: String?,
    val price: Int?,
    val previewImage: Int?,
    val color: String?,
    val colors: List<Color>?,
    val description: String?,
    val images: List<Int>? = null,
    val onWishList: Boolean?,
    val quantity: Int?,
    val size: String?,
    val sizes: List<Size>?,
)

@Keep
data class Color(
    val available: Boolean?,
    val color: String?,
    val previewImage: Int?,
    val productId: Int?
)

@Keep
data class Size(
    val available: Boolean?,
    val previewImage: Int?,
    val productId: Int?,
    val size: String?
)