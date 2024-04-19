package domain.retrofit

import com.chuckerteam.chucker.api.ChuckerInterceptor
import domain.retrofit.interceptors.AuthInterceptor
import domain.retrofit.interceptors.ExceptionInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class OkHttpBuilder(
    private val httpLoggingInterceptor: HttpLoggingInterceptor,
    private val exceptionInterceptor: ExceptionInterceptor,
    private val chuckerInterceptor: ChuckerInterceptor,
    private val authInterceptor: AuthInterceptor,
) {
    fun buildOkHttpClient(): OkHttpClient {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
//        builder.hostnameVerifier { hostname, session ->
//            return@hostnameVerifier HttpsURLConnection.getDefaultHostnameVerifier().verify(ffinbank.utils.BuildConfig.SERVER_URL, session)
//        }
        builder.setTimeout()
        builder.addInterceptor(httpLoggingInterceptor)
        builder.addInterceptor(exceptionInterceptor)
        builder.addInterceptor(chuckerInterceptor)
        builder.addInterceptor(authInterceptor)
        builder.retryOnConnectionFailure(true)

        return builder.build()
    }
}

private const val TIMEOUT = 60L

private fun OkHttpClient.Builder.setTimeout(): OkHttpClient.Builder {
    connectTimeout(TIMEOUT, TimeUnit.SECONDS)
    readTimeout(TIMEOUT, TimeUnit.SECONDS)
    writeTimeout(TIMEOUT, TimeUnit.SECONDS)

    return this
}
