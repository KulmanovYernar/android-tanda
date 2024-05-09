package tandapp.chatmodule.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tandapp.chatmodule.viewmodels.ChatViewModel

val chatModule = module {
    viewModel {
        ChatViewModel(chatRepository = get())
    }
}