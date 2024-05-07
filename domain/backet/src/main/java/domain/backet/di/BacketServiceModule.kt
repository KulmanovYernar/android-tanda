package domain.backet.di

import domain.backet.BacketRepository
import domain.backet.BacketRepositoryImpl
import domain.backet.BacketService
import domain.retrofit.di.networkModule
import org.koin.dsl.module
import retrofit2.Retrofit

private val backetServiceModule = module {
    includes(networkModule)
    single { get<Retrofit>().create(BacketService::class.java) }
}

val backetRepositoryModule = module {
    includes(backetServiceModule)
    single<BacketRepository> { BacketRepositoryImpl(get()) }
}