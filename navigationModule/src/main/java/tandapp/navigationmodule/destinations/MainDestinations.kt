package tandapp.navigationmodule.destinations

import androidx.annotation.StringRes
import tandapp.icons.R

enum class MainDestinations(
    @StringRes val title: Int,
    val destination: String,
    val icon: Int = 0
) {
    HOME(tandapp.utillibrary.R.string.main, "main", R.drawable.ic_home),
    CATALOG(tandapp.utillibrary.R.string.catalog, "catalog", R.drawable.ic_catalog),
    CHAT(tandapp.utillibrary.R.string.chat, "chat", R.drawable.ic_chat),
    BACKET(tandapp.utillibrary.R.string.basket, "backet", R.drawable.ic_backet),
    PROFILE(tandapp.utillibrary.R.string.profile, "profile", R.drawable.ic_profile ),
}