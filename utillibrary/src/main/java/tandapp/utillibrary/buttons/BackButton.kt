package tandapp.utillibrary.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import tandapp.utillibrary.click
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.fontSize18
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing6

@Composable
fun BackButton(
    onClick: () -> Unit,
    buttonText: String,
) {

    Box(
        Modifier
            .fillMaxWidth()
            .padding(spacing16), contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .click {
                    onClick()
                },
        ) {
            Icon(
                painter = painterResource(id = tandapp.icons.R.drawable.ic_back_blue),
                contentDescription = null,
                tint = Color.Blue
            )
            Spacer(modifier = Modifier.width(spacing6))
            Text(
                text = buttonText,
                fontSize = fontSize18,
                fontWeight = FontWeight.Medium,
                color = Color.Blue,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}