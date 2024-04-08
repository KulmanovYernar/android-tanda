package tandapp.utillibrary.toolbars

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import tandapp.icons.R
import tandapp.utillibrary.buttons.BackButton
import tandapp.utillibrary.click
import tandapp.utillibrary.values.Blue1
import tandapp.utillibrary.values.Silver3
import tandapp.utillibrary.values.fontSize16
import tandapp.utillibrary.values.fontSize18
import tandapp.utillibrary.values.fontSize22
import tandapp.utillibrary.values.lineHeight22
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing6
import tandapp.utillibrary.values.spacing8

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


@Composable
fun DefaultToolbarWithRightIcon(
    onBackClick: () -> Unit,
    buttonText: String,
    title: String = "",
    @DrawableRes icon: Int? = null
) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(top = spacing4, bottom = spacing4)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .click {
                    onBackClick()
                },
        ) {
            Icon(
                painter = painterResource(id = tandapp.icons.R.drawable.ic_back_blue),
                contentDescription = null,
                tint = Color.Blue
            )
            if (buttonText?.isNotBlank() == true) {
                Spacer(modifier = Modifier.width(spacing6))
                Text(
                    text = buttonText,
                    fontSize = fontSize18,
                    fontWeight = FontWeight.Medium,
                    color = Blue1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            if (icon != null) {
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_like),
                    contentDescription = null,
                    tint = Silver3,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }
    }
}

@Composable
fun DefaultToolbarWithEditButton(
    title: String = "",
    titleColor: Color = Color.Black,
    onEditClick: () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(vertical = spacing8)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
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
                    text = "Изменить",
                    fontSize = fontSize16,
                    lineHeight = lineHeight22,
                    color = Color.Blue,
                    modifier = Modifier.click {
                        onEditClick()
                    }
                )
            }
        }
    }
}

@Composable
fun DefaultToolbarTitle(
    title: String = "",
    titleColor: Color = Color.Black,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(vertical = spacing8)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = title,
                    fontSize = fontSize22,
                    fontWeight = FontWeight.Bold,
                    color = titleColor,
                )
            }
        }
    }
}
