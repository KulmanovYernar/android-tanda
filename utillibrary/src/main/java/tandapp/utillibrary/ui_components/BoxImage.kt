package tandapp.utillibrary.ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.cornerRadius12

@Composable
fun BoxImage(
    modifier: Modifier = Modifier,
    imageRes: Int,
    alpha: Float = 1f,
    boxSize: Dp = 40.dp,
    backgroundColor: Color = Purple,
    tint: Color = Color.White,
    maxHeight: Dp = 20.dp,
    maxWidth: Dp = 20.dp,
    cornerRadius: Dp = cornerRadius12
) {
    Box(
        modifier = modifier
            .background(
                color = backgroundColor.copy(alpha = alpha),
                shape = RoundedCornerShape(cornerRadius)
            )
            .clip(RoundedCornerShape(cornerRadius))
            .size(boxSize),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(imageRes),
            contentDescription = null,
            tint = tint,
            modifier = Modifier.size(maxWidth, maxHeight)
        )
    }
}