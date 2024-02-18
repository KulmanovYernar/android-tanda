package tandapp.utillibrary.toolbars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import tandapp.utillibrary.buttons.BackButton
import tandapp.utillibrary.click
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.fontSize16
import tandapp.utillibrary.values.fontSize18
import tandapp.utillibrary.values.fontSize22
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing24
import tandapp.utillibrary.values.spacing4

@Composable
fun DefaultToolbar(
    onBackClick: () -> Unit,
    buttonText: String,
    title: String = ""
) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(top = spacing4, bottom = spacing4)
    ) {
        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))


        BackButton(buttonText = buttonText, onClick = onBackClick)

        if (title.isNotEmpty()) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(start = spacing16),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = title,
                    fontSize = fontSize22,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}