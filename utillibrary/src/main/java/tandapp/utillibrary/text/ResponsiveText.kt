package tandapp.utillibrary.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import tandapp.utillibrary.values.fontSize13
import tandapp.utillibrary.values.fontSize40
import tandapp.utillibrary.values.lineHeight32

private const val TEXT_SCALE_REDUCTION_INTERVAL = 0.9f
private const val SMALL_TEXT_SCALE_REDUCTION_INTERVAL = 0.6f

@Composable
fun ResponsiveText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.White,
    style: TextStyle = TextStyle.Default,
    textAlign: TextAlign = TextAlign.Center,
    lineHeight: TextUnit = lineHeight32,
    fontWeight: FontWeight = FontWeight.Bold,
    targetTextSizeHeight: TextUnit = fontSize40,
    maxLines: Int = 1,
) {
    var textSize by remember { mutableStateOf(targetTextSizeHeight) }

    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontSize = textSize,
        textAlign = textAlign,
        style = style,
        lineHeight = lineHeight,
        fontWeight = fontWeight,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        onTextLayout = { textLayoutResult ->
            val maxCurrentLineIndex: Int = textLayoutResult.lineCount - 1

            if (textLayoutResult.isLineEllipsized(maxCurrentLineIndex)) {
                textSize = textSize.times(
                    if (targetTextSizeHeight == fontSize13) {
                        SMALL_TEXT_SCALE_REDUCTION_INTERVAL
                    } else {
                        TEXT_SCALE_REDUCTION_INTERVAL
                    }
                )
            }
        }
    )
}