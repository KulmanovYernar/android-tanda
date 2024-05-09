package tandapp.chatmodule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import tandapp.utillibrary.values.fontSize14
import tandapp.utillibrary.values.lineHeight10
import tandapp.utillibrary.values.lineHeight18

@Composable
fun MessageItem(text: String) {

    Box(modifier = Modifier.background(Color.White)) {
        Text(
            text = text,
            fontSize = fontSize14,
            lineHeight = lineHeight18,
            color = Color.Black
        )

    }
}