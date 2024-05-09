package domain.chat.di

import domain.chat.ChatRepository
import domain.chat.ChatRepositoryImpl
import domain.chat.ChatService
import domain.retrofit.di.networkModule
import org.koin.dsl.module
import retrofit2.Retrofit

private val chatServiceModule = module {
    includes(networkModule)
    single { get<Retrofit>().create(ChatService::class.java) }
}

val chatRepositoryModule = module {
    includes(chatServiceModule)
    single<ChatRepository> { ChatRepositoryImpl(get()) }
}