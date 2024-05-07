package domain.profile.models

import androidx.annotation.Keep

@Keep
data class WishListModel(
    val products: List<ProductModel>
)


@Keep
data class ProductModel(
    val brand: String?,
    val color: String?,
    val colors: List<Color>?,
    val description: String?,
    val id: Int?,
    val images: List<Int>?,
    val onWishList: Boolean?,
    val previewImage: Int?,
    val price: Int?,
    val quantity: Int?,
    val size: String?,
    val sizes: List<Size>?,
    val title: String?
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