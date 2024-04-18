package tandapp.utils

import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

private const val ACCESS_TOKEN = "accessToken"
private const val REGISTERED = "registered"


object SharedPreferencesHelper {
    private lateinit var preferences: SharedPreferences

    private val _onLogged = MutableStateFlow<Boolean?>(null)
    val onLogged = _onLogged.asStateFlow()
    fun init(
        commonPreferences: SharedPreferences,
    ) {
        this.preferences = commonPreferences
    }

    fun clear() {
        _onLogged.value = false
        preferences.edit().clear().apply()
    }

    fun saveAccessToken(accessToken: String) {
        preferences.edit().putString(ACCESS_TOKEN, accessToken).apply()
    }
    fun saveRegistered(registered: Boolean) {
        _onLogged.value = true
        preferences.edit().putBoolean(REGISTERED, registered).apply()
    }

    fun getAccessToken() = preferences.getString(ACCESS_TOKEN, "")

    fun getRegistered(): Boolean {
        _onLogged.value = preferences.getBoolean(REGISTERED, false)
        return preferences.getBoolean(REGISTERED, false)
    }

}