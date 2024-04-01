package tandapp.utillibrary.toolbars

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.fontSize16
import tandapp.utillibrary.values.fontSize22
import tandapp.utillibrary.values.lineHeight22
import tandapp.utillibrary.values.spacing12
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing8

@Composable
fun DefaultHomeToolbar(
    title: String = "",
    city: String = "",
    icon: Int? = null,
    titleColor: Color = Purple,
    onCityClick: () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(vertical = spacing8)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            if (icon != null) {
                Icon(
                    imageVector = ImageVector.vectorResource(icon),
                    contentDescription = null,
                    tint = Purple,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(spacing8))
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = title,
                    fontSize = fontSize22,
                    fontWeight = FontWeight.Bold,
                    color = titleColor,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Алматы",
                    fontSize = fontSize16,
                    lineHeight = lineHeight22,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(spacing4))
                Icon(
                    imageVector = ImageVector.vectorResource(tandapp.icons.R.drawable.ic_arrow_down),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}


@Composable
fun DefaultChatToolbar(
    onBackClick: () -> Unit,
    title: String = "",
    @DrawableRes icon: Int = tandapp.icons.R.drawable.ic_robot
) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(top = spacing4, bottom = spacing4)
    ) {
        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))

        Row(modifier = Modifier.fillMaxWidth()) {
//            BackButton(onClick = onBackClick)
            Spacer(modifier = Modifier.width(spacing8))
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(spacing12))
            if (title.isNotEmpty()) {
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
