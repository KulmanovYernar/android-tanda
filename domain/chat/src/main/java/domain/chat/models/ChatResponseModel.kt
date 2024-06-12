package domain.chat.models

import androidx.annotation.Keep
import tandapp.utillibrary.ProductModel

@Keep
data class ChatResponseModel(
    val productDto: ProductModel? = null,
    val messages: String? = null
)
