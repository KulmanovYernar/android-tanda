package tandapp.utillibrary.textfields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import tandapp.utillibrary.click
import tandapp.utillibrary.values.Base200
import tandapp.utillibrary.values.Base500
import tandapp.utillibrary.values.Base900
import tandapp.utillibrary.values.cornerRadius12
import tandapp.utillibrary.values.fontSize16
import tandapp.utillibrary.values.lineHeight22
import tandapp.utillibrary.values.spacing12
import tandapp.utillibrary.values.spacing16

@Composable
fun SearchText(text: String, hint: String, onClick: () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(cornerRadius12))
            .click { onClick() }
            .background(color = Base200)
            .padding(horizontal = spacing16, vertical = spacing12),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = tandapp.icons.R.drawable.ic_search),
            contentDescription = null,
            tint = Base500,
            modifier = Modifier
                .size(18.dp)
                .padding(1.dp)
        )
        Spacer(modifier = Modifier.width(spacing12))
        Text(
            text = text.ifEmpty { hint },
            fontSize = fontSize16,
            lineHeight = lineHeight22,
            fontWeight = FontWeight.Normal,
//            style = regular,
            color = if (text.isEmpty()) Base500 else Base900,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}