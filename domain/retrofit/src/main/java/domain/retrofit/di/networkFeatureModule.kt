package domain.retrofit.di

import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.GsonBuilder
import domain.retrofit.OkHttpBuilder
import domain.retrofit.interceptors.ExceptionInterceptor
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tandapp.utils.BuildConfig

internal val gsonInstanceModule = module {
    single { GsonBuilder().setLenient().create() }
}

internal val interceptorsModule = module {
    factory { HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) }
    factory { ExceptionInterceptor() }
    factory {
        ChuckerInterceptor.Builder(get())
            .collector(ChuckerCollector(get()))
            .build()
    }
}

internal val okHttpBuilderInstance = module {
    includes(interceptorsModule)
    single { OkHttpBuilder(get(), get(), get()).buildOkHttpClient() }
}

val networkModule = module {
    includes(gsonInstanceModule)
    includes(okHttpBuilderInstance)

    single<Retrofit> {
        val gsonConverterFactory = GsonConverterFactory.create(get())

        Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(get())
            .build()
    }
}