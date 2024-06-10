package tandapp.chatmodule.viewmodels

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.chat.ChatRepository
import domain.chat.models.ChatResponseModel
import domain.chat.models.MessageBox
import domain.chat.models.MessageType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import tandapp.utillibrary.ProductModel

class ChatViewModel(
    private val chatRepository: ChatRepository
) : ViewModel() {

    val receivedMessage: MutableStateFlow<ProductModel?> = MutableStateFlow(null)
    val conversation: MutableStateFlow<MutableList<MessageBox>?> = MutableStateFlow(
        mutableListOf<MessageBox>(
        MessageBox(
            "Welcome to Tandapp!",
            null,
            MessageType.IN
        )
    ))

    init {
    }

    fun sendMessage(text: String) {
        viewModelScope.launch {
            updateList(
                MessageBox(
                    text = text,
                    product = null,
                    type = MessageType.OUT
                )
            )
            chatRepository.sendMessage(text).collect {
                it.onSuccess {
                    val result = it as ProductModel
                    receivedMessage.value = result
                    updateList(
                        MessageBox(
                            text = "",
                            product = receivedMessage?.value,
                            type = MessageType.IN
                        )
                    )
                }
            }
        }
    }

    fun updateList(model: MessageBox){
        val newList = conversation.value?.toMutableList()
        newList?.add(model)
        conversation.value = newList

    }
}