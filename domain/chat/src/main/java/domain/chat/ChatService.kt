package domain.chat

import domain.chat.models.ChatResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatService {

    @POST("chat/query")
    suspend fun requestChatQuery(@Body data: String): Response<ChatResponseModel>
}