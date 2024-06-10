package tandapp.utillibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import tandapp.utillibrary.values.Base50
import tandapp.utillibrary.values.Green500
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.spacing12

@Composable
fun Loading(dark: Boolean = false, bgColor: Color = Base50.copy(alpha = 0.5f)) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(modifier = Modifier
        .fillMaxSize()
        .clickable(enabled = false, interactionSource = interactionSource, indication = null) {

        }
        .background(color = bgColor), contentAlignment = Alignment.Center) {
        AppLoader()
    }
}

@Composable
fun AppLoader(bgColor: Color = Base50, size: Dp = 48.dp) {
    Box(
        modifier = Modifier
            .advancedShadow()
            .background(color = bgColor, shape = CircleShape)
            .padding(spacing12)
    ) {
        CircularProgressIndicator(color = Purple, modifier = Modifier.size(size))
    }
}