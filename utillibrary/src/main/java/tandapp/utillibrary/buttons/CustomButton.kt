package tandapp.utillibrary.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import tandapp.utillibrary.text.ResponsiveText
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.cornerRadius16
import tandapp.utillibrary.values.fontSize18
import tandapp.utillibrary.values.lineHeight24
import tandapp.utillibrary.values.spacing8

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = Purple,
//        contentColor = StaticBase50,
//        disabledBackgroundColor = DisableButtonColor,
//        disabledContentColor = StaticBase50
    ),
    enabled: Boolean = true,
    minClickSec: Long = 500,
    height: Dp = 52.dp,
    maxHeight: Dp = 52.dp,
    cornerRadius: Dp = cornerRadius16,
    elevation: ButtonElevation? = ButtonDefaults.elevation(
        defaultElevation = 0.dp,
        pressedElevation = 0.dp,
        hoveredElevation = 0.dp,
        focusedElevation = 0.dp
    ),
    content: @Composable RowScope.() -> Unit,
    onButtonClicked: () -> Unit
) {
    var lastClickSec = remember {
        0L
    }
    Button(
        onClick = {
            if (System.currentTimeMillis() - lastClickSec > minClickSec) {
                lastClickSec = System.currentTimeMillis()
                onButtonClicked()
            }
        },
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .heightIn(min = height, max = maxHeight),
        colors = buttonColors,
        enabled = enabled,
        content = content,
        elevation = elevation
    )
}

@Composable
fun CustomButtonText(
    text: String,
    color: Color = Color.White,
    fontSize: TextUnit = fontSize18,
    fontWeight: FontWeight = FontWeight.SemiBold,
    lineHeight: TextUnit = lineHeight24,
    trailingIcon: (@Composable () -> Unit)? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    horizontalArrangement:Arrangement.Horizontal = Arrangement.Center,
    verticalAlignment:Alignment.Vertical = Alignment.CenterVertically,
    showIcon: Boolean = false
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = verticalAlignment
    ) {
        if (leadingIcon != null && showIcon) {
            leadingIcon()
            Spacer(modifier = Modifier.width(spacing8))
        }
        ResponsiveText(
            modifier = Modifier.weight(1f, fill = false),
            text = text,
            targetTextSizeHeight = fontSize,
            fontWeight = fontWeight,
            lineHeight = lineHeight,
//            style = semiBold,
            color = color
        )
        if (trailingIcon != null && showIcon) {
            Spacer(modifier = Modifier.width(spacing8))
            trailingIcon()
        }
    }
}