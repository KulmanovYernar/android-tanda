package tandapp.chatmodule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import domain.chat.models.MessageBox
import domain.chat.models.MessageType
import tandapp.utillibrary.click
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.cornerRadius16
import tandapp.utillibrary.values.fontSize14
import tandapp.utillibrary.values.fontSize18
import tandapp.utillibrary.values.lineHeight10
import tandapp.utillibrary.values.lineHeight18
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing32
import tandapp.utillibrary.values.spacing36
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing44
import tandapp.utillibrary.values.spacing8

@Composable
fun MessageItem(
    model: MessageBox?,
    onClickProduct: () -> Unit = {}
) {

    val contentCornerRadius = remember {
        RoundedCornerShape(
            topStart = cornerRadius16,
            topEnd = cornerRadius16,
            bottomStart = if (model?.type == MessageType.OUT) cornerRadius16 else 4.dp,
            bottomEnd = if (model?.type == MessageType.OUT) 4.dp else cornerRadius16
        )
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (model?.type == MessageType.IN) Arrangement.Start else Arrangement.End
    ) {
        Box(
            modifier = Modifier
                .clip(contentCornerRadius)
                .padding()
                .background(
                    if (model?.type == MessageType.IN) Color.White
                    else Purple,
                    shape = contentCornerRadius
                )
                .padding(spacing8),
            contentAlignment = if (model?.type == MessageType.IN) Alignment.CenterStart
            else Alignment.CenterEnd,
        ) {
            if (model?.product != null) {
                AsyncImage(
                    model = "http://91.147.105.187:9000/product/get_image/${model?.product?.previewImage}",
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .click {
                            onClickProduct()
                        }
                )
            } else {
                Text(
                    text = model?.text.orEmpty(),
                    fontSize = fontSize18,
                    lineHeight = lineHeight18,
                    color = if (model?.type == MessageType.IN) Color.Black else Color.White,
                    modifier = Modifier.align(
                        if (model?.type == MessageType.IN) Alignment.CenterStart else
                            Alignment.CenterEnd
                    )
                )
            }
        }

    }
}