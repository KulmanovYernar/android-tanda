package domain.backet.models

import androidx.annotation.Keep

@Keep
data class BacketItem(
    val productId: Int?,
    val quantity: Int?,
    val selected: Boolean?
)