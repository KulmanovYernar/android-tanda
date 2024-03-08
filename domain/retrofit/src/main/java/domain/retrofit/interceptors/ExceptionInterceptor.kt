package domain.retrofit.interceptors

import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.internal.http2.ConnectionShutdownException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ExceptionInterceptor : Interceptor {
    companion object {
        val SocketTimeoutException = "SocketTimeoutException"
        val UnknownHostException = "UnknownHostException"
        val ConnectionShutdownException = "ConnectionShutdownException"
        val IOException = "IOException"
        val IllegalStateException = "IllegalStateException"
        val UnknownException = "UnknownException"
    }
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        try {
            val response = chain.proceed(request)

            val bodyString = response.body!!.string()

            return response.newBuilder()
                .body(ResponseBody.create(response.body?.contentType(), bodyString))
                .build()
        } catch (e: Exception) {
            e.printStackTrace()
            var msg = ""
            var errorType = ""
            when (e) {
                is SocketTimeoutException -> {
                    msg = "Timeout - Please check your internet connection"
                    errorType = SocketTimeoutException
                }
                is UnknownHostException -> {
                    msg = "Unable to make a connection. Please check your internet"
                    errorType = UnknownHostException
                }
                is ConnectionShutdownException -> {
                    msg = "Connection shutdown. Please check your internet"
                    errorType = ConnectionShutdownException
                }
                is IOException -> {
                    msg = "Server is unreachable, please try again later."
                    errorType = IOException
                }
                is IllegalStateException -> {
                    msg = "${e.message}"
                    errorType = IllegalStateException
                }
                else -> {
                    msg = "${e.message}"
                    errorType = UnknownException
                }
            }

            return Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .code(999)
                .message(msg).addHeader("Error-Type", errorType)
                .body(ResponseBody.create(null, "{${e}}")).build()
        }
    }
}