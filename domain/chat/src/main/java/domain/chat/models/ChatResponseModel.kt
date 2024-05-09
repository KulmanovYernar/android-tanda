package domain.chat.models

import androidx.annotation.Keep
import tandapp.utillibrary.ProductModel

@Keep
data class ChatResponseModel(
    val product: ProductModel?,
    val message: String?
)
