package tandapp.utils

import android.content.SharedPreferences

private const val ACCESS_TOKEN = "accessToken"
object SharedPreferencesHelper {
    private lateinit var preferences: SharedPreferences

    fun init(
        commonPreferences: SharedPreferences,
    ) {
        this.preferences = commonPreferences
    }
    fun clear() {
        preferences.edit().clear().apply()
    }

    fun saveAccessToken(accessToken: String) {
        preferences.edit().putString(ACCESS_TOKEN, accessToken).apply()
    }

    fun getAccessToken() = preferences.getString(ACCESS_TOKEN, "")

}