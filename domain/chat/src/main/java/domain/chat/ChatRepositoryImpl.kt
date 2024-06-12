package domain.chat

import domain.chat.models.ChatModel
import kotlinx.coroutines.flow.flow
import tandapp.domain.event.Event

class ChatRepositoryImpl(private val service: ChatService) : ChatRepository {
    override suspend fun sendMessage(text: String) = flow {
        emit(Event.loading())

        val response = service.requestChatQuery(
            ChatModel(
                query = text
            )
        )

        if (response.isSuccessful) emit(Event.success(response.body()))
        else emit(Event.error(response.message()))
    }

}