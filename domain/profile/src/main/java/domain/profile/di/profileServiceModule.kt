package domain.profile.di

import domain.profile.ProfileRepository
import domain.profile.ProfileRepositoryImpl
import domain.profile.ProfileService
import domain.retrofit.di.networkModule
import org.koin.dsl.module
import retrofit2.Retrofit

private val profileServiceModule = module {
    includes(networkModule)
    single { get<Retrofit>().create(ProfileService::class.java) }
}

val profileRepositoryModule = module {
    includes(profileServiceModule)
    single<ProfileRepository> { ProfileRepositoryImpl(get()) }
}