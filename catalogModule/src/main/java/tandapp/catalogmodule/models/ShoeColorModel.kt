package tandapp.catalogmodule.models

import androidx.annotation.Keep
import androidx.compose.ui.graphics.Color

@Keep
data class ShoeColorModel(
    val id: Int,
    val color: Color,
    val title: String,
)
