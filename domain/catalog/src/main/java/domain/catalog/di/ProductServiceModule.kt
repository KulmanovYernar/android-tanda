package domain.catalog.di

import domain.catalog.ProductRepository
import domain.catalog.ProductRepositoryImpl
import domain.catalog.ProductService
import domain.retrofit.di.networkModule
import org.koin.dsl.module
import retrofit2.Retrofit

private val productServiceModule = module {
    includes(networkModule)
    single { get<Retrofit>().create(ProductService::class.java) }
}

val productRepositoryModule = module {
    includes(productServiceModule)
    single<ProductRepository> { ProductRepositoryImpl(get()) }
}