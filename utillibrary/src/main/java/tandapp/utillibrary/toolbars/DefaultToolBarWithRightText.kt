package tandapp.utillibrary.toolbars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
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
import tandapp.utillibrary.click
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.fontSize16
import tandapp.utillibrary.values.fontSize18
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing4

//@Composable
//fun DefaultToolbar(
//    title: String,
//    backgroundColor: Color = Base50,
//    backIcon: Int = R.drawable.ic_back_arrow,
//    toolbarTextEndPadding: Dp = 48.dp,
//    textColor: Color = Base900,
//    fontSize: TextUnit = fontSize18,
//    fontWeight: FontWeight = FontWeight.Bold,
//    textStyle: TextStyle = bold,
//    iconColor: Color = Base900,
//    showBackButton: Boolean = true,
//    onBackClick: () -> Unit = { }
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(color = backgroundColor)
//    ) {
//        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
//
//        Row(
//            modifier = Modifier.padding(spacing4),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            if (showBackButton) {
//                BackButton(
//                    iconRes = backIcon,
//                    iconColor = iconColor,
//                    onBackClick = onBackClick
//                )
//            } else {
//                Box(modifier = Modifier.size(48.dp))
//            }
//
//            Box(
//                modifier = Modifier
//                    .weight(1f),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = title,
//                    fontSize = fontSize,
//                    fontWeight = fontWeight,
//                    textAlign = TextAlign.Center,
//                    style = textStyle,
//                    color = textColor,
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )
//            }
//
//            Box(
//                modifier = Modifier
//                    .height(48.dp)
//                    .width(toolbarTextEndPadding)
//            )
//        }
//    }
//}
//
//@Composable
//fun DefaultToolbarFlow(
//    title: String,
//    backgroundColor: Color = Base50,
//    backIcon: Int = R.drawable.ic_back_arrow,
//    textColor: Color = Base900,
//    fontSize: TextUnit = fontSize18,
//    fontWeight: FontWeight = FontWeight.Bold,
//    textStyle: TextStyle = bold,
//    iconColor: Color = Base900,
//    showBackButton: Boolean = true,
//    onBackClick: () -> Unit = { },
//    onCloseFlowClick: () -> Unit = { }
//) {
//
//    Column(
//        Modifier
//            .fillMaxWidth()
//            .background(color = backgroundColor)
//            .padding(top = spacing4, bottom = spacing4)
//    ) {
//        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
//        Box(
//            Modifier
//                .padding(start = spacing4)
//                .fillMaxWidth()
//                .height(spacing48),
//            contentAlignment = Alignment.CenterStart
//        ) {
//            Text(
//                text = "Отмена",
//                color = Green500,
//                fontSize = fontSize16,
//                fontWeight = FontWeight.Medium,
//                modifier = Modifier
//                    .padding(start = spacing16)
//                    .click {
//                        onBackClick.invoke()
//                    }
//            )
//
//            Box(
//                Modifier
//                    .fillMaxWidth(), contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = title,
//                    style = textStyle,
//                    fontSize = fontSize,
//                    fontWeight = fontWeight,
//                    modifier = Modifier,
//                    color = textColor,
//                    textAlign = TextAlign.Center,
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun DefaultToolbarTextRow(
//    title: String,
//    backgroundColor: Color = Base50,
//    textColor: Color = Base900,
//    fontSize: TextUnit = fontSize18,
//    fontWeight: FontWeight = FontWeight.Bold,
//    textStyle: TextStyle = bold,
//    onBackClick: () -> Unit
//) {
//
//    Column(
//        Modifier
//            .fillMaxWidth()
//            .background(color = backgroundColor)
//            .padding(top = spacing4, bottom = spacing4)
//    ) {
//        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
//        Row(
//            Modifier
//                .padding(start = spacing4, end = spacing4)
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            BackButton(iconColor = textColor, onBackClick = onBackClick)
//            Spacer(modifier = Modifier.height(spacing24))
//            Text(
//                text = title,
//                style = textStyle,
//                fontSize = fontSize,
//                fontWeight = fontWeight,
//                modifier = Modifier,
//                color = textColor,
//                textAlign = TextAlign.Center,
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis
//            )
//        }
//    }
//}
//
//@Composable
//fun DefaultToolbarLeftText(
//    title: String,
//    backgroundColor: Color = Base50,
//    textColor: Color = Base900,
//    fontSize: TextUnit = fontSize18,
//    fontWeight: FontWeight = FontWeight.Bold,
//    textStyle: TextStyle = bold,
//    onBackClick: () -> Unit
//) {
//
//    Column(
//        Modifier
//            .fillMaxWidth()
//            .background(color = backgroundColor)
//            .padding(top = spacing4, bottom = spacing4)
//    ) {
//        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
//        Row(
//            Modifier
//                .padding(start = spacing4)
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            BackButton(
//                iconRes = R.drawable.ic_close_x,
//                iconColor = textColor,
//                onBackClick = onBackClick
//            )
//            Spacer(modifier = Modifier.height(spacing24))
//            Text(
//                text = title,
//                style = textStyle,
//                fontSize = fontSize,
//                fontWeight = fontWeight,
//                modifier = Modifier,
//                color = textColor,
//                textAlign = TextAlign.Center,
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis
//            )
//        }
//    }
//}
//
//@Composable
//fun DefaultToolbarOnlyRightIcon(
//    modifier: Modifier = Modifier,
//    title: String,
//    backgroundColor: Color = Base50,
//    fontSize: TextUnit = fontSize16,
//    textColor: Color = Base900,
//    iconColor: Color = Base900,
//    backIcon: Int = R.drawable.ic_close_x,
//    onBackClick: () -> Unit
//) {
//    Column(
//        modifier = modifier
//            .fillMaxWidth()
//            .background(color = backgroundColor)
//    ) {
//        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
//
//        Row(
//            modifier = Modifier.padding(spacing4),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Box(
//                modifier = Modifier
//                    .weight(1f),
//            ) {
//                Text(
//                    text = title,
//                    fontSize = fontSize,
//                    fontWeight = FontWeight.SemiBold,
//                    textAlign = TextAlign.Center,
//                    style = bold,
//                    color = textColor,
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis,
//                    modifier = Modifier.align(Alignment.Center)
//                )
//
//                BackButton(
//                    iconColor = iconColor,
//                    iconRes = backIcon,
//                    onBackClick = {
//                        onBackClick()
//                    },
//                    modifier = Modifier.align(Alignment.CenterEnd)
//                )
//            }
//        }
//    }
//}

@Composable
fun DefaultToolbarWithRightText(
    title: String = "",
    backgroundColor: Color = Color.White,
    onBackClick: () -> Unit = {},
    rightText: String = "",
    onRightTextClick: () -> Unit = {}
) {

    Column(
        Modifier
            .fillMaxWidth()
            .background(color = backgroundColor)
            .padding(top = spacing4, bottom = spacing4)
    ) {
        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
        Box(
            Modifier
                .padding(start = spacing4)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
//            BackButton(iconRes = backIcon, iconColor = Base900, onBackClick = onBackClick)

            if(title.isNotEmpty()) {
                Box(
                    Modifier
                        .fillMaxWidth(), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title,
                        fontSize = fontSize18,
                        fontWeight = FontWeight.SemiBold,
//                        style = semiBold,
                        color = Purple,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            if (rightText.isNotEmpty()) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(end = spacing16), contentAlignment = Alignment.CenterEnd
                ) {
                    Box(
                        modifier = Modifier
                            .click {
                                onRightTextClick()
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = rightText,
                            fontSize = fontSize16,
                            fontWeight = FontWeight.Medium,
//                            style = medium,
                            color = Purple,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}

//@Composable
//fun DefaultToolbarWithRightIcon(
//    modifier: Modifier = Modifier,
//    title: String,
//    backgroundColor: Color = Base50,
//    backIcon: Int = R.drawable.ic_back_arrow,
//    fontSize: TextUnit = fontSize16,
//    onBackClick: () -> Unit,
//    rightIcon: Int = R.drawable.ic_line_correct,
//    rightIconTint: Color = Base900,
//    onRightIconClick: () -> Unit = {}
//) {
//    Column(
//        modifier = modifier
//            .fillMaxWidth()
//            .background(color = backgroundColor)
//    ) {
//        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
//        Row(
//            modifier = Modifier.padding(spacing4),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//
//            Box(
//                modifier = Modifier
//                    .size(spacing48)
//                    .click {
//                        onBackClick()
//                    },
//                contentAlignment = Alignment.Center
//            ) {
//                Icon(
//                    painter = painterResource(id = backIcon),
//                    contentDescription = null,
//                    tint = Base900
//                )
//            }
//            Box(
//                modifier = Modifier
//                    .weight(1f),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = title,
//                    fontSize = fontSize,
//                    fontWeight = FontWeight.SemiBold,
//                    textAlign = TextAlign.Center,
//                    style = semiBold,
//                    color = Base900,
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )
//            }
//            Box(
//                modifier = Modifier
//                    .size(spacing48)
//                    .clickable {
//                        onRightIconClick()
//                    },
//                contentAlignment = Alignment.Center
//            ) {
//                Icon(
//                    painter = painterResource(rightIcon),
//                    contentDescription = null,
//                    tint = rightIconTint
//                )
//            }
//        }
//    }
//}

//@Composable
//fun DefaultToolbarWithTwoTitle(
//    title: String,
//    subtitle: String,
//    titleTextColor: Color = Base500,
//    subtitleTextColor: Color = Base900,
//    backgroundColor: Color = Base50,
//    onBackClick: () -> Unit
//) {
//
//    Column(
//        Modifier
//            .fillMaxWidth()
//            .padding(top = spacing4, bottom = spacing4)
//            .background(color = backgroundColor)
//    ) {
//        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
//
//        Box(
//            Modifier
//                .padding(start = spacing4)
//                .fillMaxWidth()
//        ) {
//
//            BackButton(iconColor = subtitleTextColor, onBackClick = onBackClick)
//
//            Column(
//                Modifier
//                    .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = title,
//                    fontSize = fontSize13,
//                    fontWeight = FontWeight.Normal,
//                    style = regular,
//                    color = titleTextColor,
//                    textAlign = TextAlign.Center
//                )
//                Text(
//                    text = subtitle,
//                    fontSize = fontSize16,
//                    fontWeight = FontWeight.SemiBold,
//                    style = semiBold,
//                    color = subtitleTextColor,
//                    textAlign = TextAlign.Center
//                )
//            }
//        }
//    }
//}
//
//            Spacer(modifier = Modifier.width(62.dp))
//
//            if (showProgressBar) {
//                LinearProgressIndicator(
//                    progress = currentProgress.toFloat() / totalProgress.toFloat(),
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(45.dp))
//                        .width(186.dp)
//                        .height(8.dp),
//                    color = Green500,
//                    backgroundColor = Base200,
//                )
//            }
//
//        }
//    }
//}

//@Composable
//fun BackButton(
//    modifier: Modifier = Modifier,
//    @DrawableRes iconRes: Int = R.drawable.ic_back_arrow,
//    iconColor: Color,
//    onBackClick: () -> Unit
//) {
//    SingleClickButton(onClick = onBackClick, modifier = modifier) {
//        Icon(
//            painter = painterResource(id = iconRes),
//            contentDescription = null,
//            tint = iconColor
//        )
//    }
//}

//@Preview
//@Composable
//private fun DefaultToolbarOnlyRightIconPreview() {
//    DefaultToolbarOnlyRightIcon(title = "Заголовок", onBackClick = {})
//}
//
//@Preview
//@Composable
//private fun DefaultToolbarWithRightTextPreview() {
//    DefaultToolbarWithRightText(title = "Заголовок", rightText = "Справа", onBackClick = {})
//}
//
//@Preview
//@Composable
//private fun DefaultToolbarWithRightIconPreview() {
//    DefaultToolbarWithRightIcon(
//        title = "Заголовок",
//        onBackClick = {},
//        onRightIconClick = {}
//    )
//}
//
//@Preview
//@Composable
//private fun DefaultToolbarPreview() {
//    DefaultToolbar(
//        title = "Заголовок",
//        onBackClick = {}
//    )
//}

//@Preview
//@Composable
//fun DefaultToolbarLongTitlePreview() {
//    DefaultToolbar(
//        title = "Looooooooooooooooooooooooooooooooong Title",
//        onBackClick = {}
//    )
//}
//
//@Preview
//@Composable
//private fun SearchToolbarPreview() {
//    SearchToolbar(
//        hint = "Код или вид деятельности",
//        text = "",
//        onTextChanged = {},
//        onDoneClick = {},
//        onCancelClick = {})
//}