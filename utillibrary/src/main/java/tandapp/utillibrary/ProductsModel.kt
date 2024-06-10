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
    val category: String?,
    val subCategory: String?,
    val color: String?,
    val colors: List<Color>?,
    val description: String?,
    val images: List<Int>? = null,
    val onWishList: Boolean?,
    val onBasket: Boolean?,
    val quantity: Int?,
    val size: String?,
    val sizes: List<Size>?,
    val hex: String?
)

@Keep
data class Color(
    val available: Boolean?,
    val color: String?,
    val previewImage: Int?,
    val productId: Int?,
    val hex: String?
)

@Keep
data class Size(
    val available: Boolean?,
    val previewImage: Int?,
    val productId: Int?,
    val size: String?
)