package domain.chat

import domain.chat.models.ChatResponseModel
import kotlinx.coroutines.flow.Flow
import tandapp.domain.event.Event
import tandapp.utillibrary.ProductModel

interface ChatRepository {
    suspend fun sendMessage(text: String): Flow<Event<ChatResponseModel>>
}