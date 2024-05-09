package tandapp.chatmodule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import domain.chat.models.MessageBox
import domain.chat.models.MessageType
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.cornerRadius16
import tandapp.utillibrary.values.fontSize14
import tandapp.utillibrary.values.lineHeight10
import tandapp.utillibrary.values.lineHeight18
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing32
import tandapp.utillibrary.values.spacing36
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing44
import tandapp.utillibrary.values.spacing8

@Composable
fun MessageItem(model: MessageBox?) {

    val paddingModifier = remember {
        if (model?.type == MessageType.OUT) Modifier.padding(start = spacing32, end = spacing16)
        else Modifier.padding(start = spacing16, end = spacing32)
    }
    val contentCornerRadius = remember {
        RoundedCornerShape(
            topStart = cornerRadius16,
            topEnd = cornerRadius16,
            bottomStart = if (model?.type == MessageType.OUT) cornerRadius16 else 4.dp,
            bottomEnd = if (model?.type == MessageType.OUT) 4.dp else cornerRadius16
        )
    }

    Box(
        modifier = Modifier
            .clip(contentCornerRadius)
            .padding(start = if (model?.type == MessageType.IN) spacing4 else 100.dp)
            .background(
                if (model?.type == MessageType.IN) Color.White
                else Purple,
                shape = contentCornerRadius
            )
            .padding(spacing8),
        contentAlignment = if (model?.type == MessageType.IN) Alignment.CenterStart
        else Alignment.CenterEnd
    ) {
        if (model?.product != null) {
            AsyncImage(
                model = "http://91.147.105.187:9000/product/get_image/${model?.product?.previewImage}",
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
            )
        } else {
            Text(
                text = model?.text.orEmpty(),
                fontSize = fontSize14,
                lineHeight = lineHeight18,
                color = if (model?.type == MessageType.IN) Color.Black else Color.White,
            )
        }

    }
}