package domain.chat.models

import androidx.annotation.Keep
import tandapp.utillibrary.ProductModel

@Keep
data class MessageBox(
    val text:String,
    val product: ProductModel?,
    val type: MessageType
)

@Keep
enum class MessageType{
    OUT, IN
}
