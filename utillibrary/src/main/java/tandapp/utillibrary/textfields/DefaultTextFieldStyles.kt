package tandapp.utillibrary.textfields

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import tandapp.utillibrary.R
import tandapp.utillibrary.click
import tandapp.utillibrary.values.Silver

@Composable
internal fun defaultTextFieldColors(cursorColor: Color): TextFieldColors {
    return TextFieldDefaults.textFieldColors(
        textColor = Color.Black,
        backgroundColor = Color.White,
        focusedIndicatorColor = Silver,
        unfocusedIndicatorColor = Silver,
        cursorColor = cursorColor,
        disabledTextColor = Color.Black,
        disabledIndicatorColor = Color.Transparent
    )
}


@Composable
internal fun DefaultTrailingIcon(
    showIcon: Boolean,
    onTrailingIconClick: () -> Unit
) {
//    if (showIcon) {
//        Image(
//            painter = painterResource(id = R.drawable.ic_close_base400),
//            contentDescription = null,
//            modifier = Modifier
//                .clip(CircleShape)
//                .size(24.dp)
//                .click(onClick = onTrailingIconClick)
//        )
//    }

}