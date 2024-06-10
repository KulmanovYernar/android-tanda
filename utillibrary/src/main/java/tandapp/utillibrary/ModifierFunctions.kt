package tandapp.utillibrary

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import tandapp.utillibrary.values.Base900
import tandapp.utillibrary.values.cornerRadius12

fun Modifier.click(enabled: Boolean = true, onClick: () -> Unit) = clickable(
    interactionSource = androidx.compose.foundation.interaction.MutableInteractionSource(),
    indication = null,
    onClick = onClick,
    enabled = enabled
)

fun Modifier.click(
    clickable: Boolean,
    enabled: Boolean = true,
    onClick: () -> Unit
): Modifier = if (clickable) then(click(enabled, onClick)) else this


fun Modifier.advancedShadow(
    color: Color = Base900.copy(alpha = 0.05f),
    alpha: Float = 0.05f,
    cornersRadius: Dp = cornerRadius12,
    shadowBlurRadius: Dp = 20.dp,
    offsetY: Dp = 5.dp,
    offsetX: Dp = 0.dp
) = drawBehind {

    val shadowColor = color.copy(alpha = alpha).toArgb()
    val transparentColor = color.copy(alpha = 0f).toArgb()

    drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            shadowBlurRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
//        it.drawRect(Rect(left = 0f, top = 0f, right = this.size.width, this.size.height), paint = s)
        it.drawRoundRect(
            1f,
            1f,
            this.size.width,
            this.size.height,
            cornersRadius.toPx(),
            cornersRadius.toPx(),
            paint
        )
    }
}
