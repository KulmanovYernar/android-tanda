package domain.chat

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import tandapp.utillibrary.ProductModel

interface ChatService {

    @POST("chat/query")
    suspend fun requestChatQuery(@Body data: String): Response<ProductModel>
}