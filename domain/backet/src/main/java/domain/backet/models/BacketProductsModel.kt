package domain.backet.models

import androidx.annotation.Keep
import tandapp.utillibrary.ProductModel
import java.math.BigDecimal

@Keep
data class BacketProductsModel(
    val productsSelected: List<ProductModel>?,
    val productsNonSelected: List<ProductModel>?,
    val totalPrice: BigDecimal?
)
