package domain.retrofit.interceptors

import android.content.Context
import android.content.pm.PackageInfo
import androidx.core.content.pm.PackageInfoCompat
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import tandapp.utils.SharedPreferencesHelper
import java.net.HttpURLConnection

class AuthInterceptor(private val context: Context) : Interceptor {


    private val mutext = Mutex()

    override fun intercept(chain: Interceptor.Chain): Response {

        val builder = chain.request()

        val packageInfo: PackageInfo? =
            context.packageManager?.getPackageInfo(
                context.packageName,
                0
            )
        var versionCode = ""
        packageInfo?.let {
            versionCode = PackageInfoCompat.getLongVersionCode(it).toString()
        }

        val appVersion = packageInfo?.versionName ?: ""
        val request = builder.newBuilder()
//            .addHeader(
//                "X-Fingerprint",
//                "mobile/${
//                    Settings.Secure.getString(
//                        context.contentResolver,
//                        Settings.Secure.ANDROID_ID
//                    )
//                }/Android/${Build.VERSION.RELEASE}/$appVersion/$versionCode"
//            )
//        try {
//            request.addHeader("X-Antifraud-Device-Name", Settings.Global.getString(context.contentResolver, Settings.Global.DEVICE_NAME))
//        } catch (e: Exception) {
//            Log.e("TAG", "intercept: Device name non ASCII", )
//        }


        val token =
            runBlocking {
                if (!SharedPreferencesHelper.getAccessToken().isNullOrEmpty()) {
                    SharedPreferencesHelper.getAccessToken()
                } else {
                    null
                }
            }

        val res = chain.proceedWithToken(request.build(), token)


        if (res.code != HttpURLConnection.HTTP_UNAUTHORIZED || token == null) {
            return res
        }


        val newToken = runBlocking {
            mutext.withLock {
                val maybeUpdatedToken = SharedPreferencesHelper.getAccessToken().orEmpty()
                if (token == maybeUpdatedToken) {
                    val r = Request.Builder()
                        .header("Content-Type", "application/x-www-form-urlencoded")
//                        .post(
//                            FormBody.Builder()
//                                .addEncoded(
//                                    "refreshToken",
//                                    SharedPreferencesHelper.getRefreshToken().orEmpty()
//                                )
//                                .build()
//                        )
                        .build()
                    val result = chain.proceed(r)


                    if (result.isSuccessful) {
                        val jsonObject = JSONObject(result.body?.string().orEmpty())
                        val accessToken = jsonObject["access_token"]
                        val refreshToken = jsonObject["refresh_token"]
                        SharedPreferencesHelper.saveAccessToken(accessToken = accessToken.toString())
//                        SharedPreferencesHelper.saveRefreshToken(token = refreshToken.toString())
                        accessToken.toString()
                    } else {
//                        UiStatusListener.status.value = UiStatus.LOGIN_ERROR
                        ""
                    }
                } else {
                    maybeUpdatedToken
                }
            }
        }


        return chain.proceedWithToken(request.build(), newToken)
    }


    private fun Interceptor.Chain.proceedWithToken(req: Request, token: String?): Response =
        req.newBuilder()
            .apply {
                removeHeader("Authorization")
            }
            .apply {
                if (token !== null) {
                    addHeader("Authorization", "Bearer $token")
                }
            }
            .build()
            .let(::proceed)
}
