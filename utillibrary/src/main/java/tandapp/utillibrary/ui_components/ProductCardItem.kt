package tandapp.utillibrary.ui_components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import tandapp.utillibrary.values.spacing12

@Composable
fun ProductCardItem(
    onBackClick: () -> Unit = {},
    sharedElementContent: @Composable () -> Unit,
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            Text(text = "<- Назад")
            Spacer(modifier = Modifier.height(spacing12))
            sharedElementContent()
            Spacer(modifier = Modifier.height(spacing12))
            Text(
                text = "Кроссовки Pierre Cardin",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 10.sp,
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                )
            )
        }
    }
}