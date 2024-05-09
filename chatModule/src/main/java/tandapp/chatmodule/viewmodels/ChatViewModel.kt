package tandapp.chatmodule.viewmodels

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.chat.ChatRepository
import domain.chat.models.ChatResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class ChatViewModel(
    private val chatRepository: ChatRepository
): ViewModel() {

    val receivedMessage: MutableStateFlow<ChatResponseModel?> = MutableStateFlow(null)


    fun sendMessage(text: String){
        viewModelScope.launch {
            chatRepository.sendMessage(text).flowOn(Dispatchers.IO).collect{
                it.onSuccess {
                    val result = it
                    receivedMessage.value = result
                }
            }
        }
    }
}