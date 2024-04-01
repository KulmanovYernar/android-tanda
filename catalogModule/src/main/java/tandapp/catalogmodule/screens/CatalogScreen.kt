package tandapp.catalogmodule.screens

import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import tandapp.navigationmodule.CustomBottomNavigation
import tandapp.utillibrary.textfields.SearchText
import tandapp.utillibrary.toolbars.DefaultToolbarTitle
import tandapp.utillibrary.values.cornerRadius10
import tandapp.utillibrary.values.cornerRadius4
import tandapp.utillibrary.values.fontSize10
import tandapp.utillibrary.values.lineHeight10
import tandapp.utillibrary.values.spacing10
import tandapp.utillibrary.values.spacing12
import tandapp.utillibrary.values.spacing14
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing20
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing8

@Composable
fun CatalogScreen(
    navController: NavController,
    onBack: (String?) -> Unit = {}
) {
    val route = navController.currentBackStackEntry?.destination?.route
    BackHandler {
        onBack(route)
    }

    val scope = rememberCoroutineScope()

    Scaffold(
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = spacing8, start = spacing16, end = spacing16)
                    .background(Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    DefaultToolbarTitle(
                        title = "Каталог",
                        titleColor = Color.Black
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(
                        top = spacing8,
                        bottom = it.calculateBottomPadding(),
                        start = spacing16,
                        end = spacing16
                    )
            ) {
                SearchText(
                    text = "",
                    onClick = {},
                    hint = "Поиск"
                )
                Spacer(modifier = Modifier.height(spacing12))

                Row {
                    Column {
                        CatalogShoesItem(
                            title = "Детские",
                            width = 174.dp,
                            height = 132.dp,
                            image = tandapp.icons.R.drawable.img_kids,
                            backgroundColor = Color(0xFFF894A0),
                        )
                        Spacer(modifier = Modifier.height(spacing14))
                        CatalogShoesItem(
                            title = "Мужские",
                            width = 174.dp,
                            height = 132.dp,
                            image = tandapp.icons.R.drawable.img_man,
                            backgroundColor = Color(0xFF5A6A74)
                        )
                    }
                    Spacer(modifier = Modifier.width(spacing16))
                    CatalogShoesItem(
                        title = "Мода 2024", width = 174.dp, height = 277.dp,
                        backgroundColor = Color(0xFF0A8B5B)
                    )
                }
                Spacer(modifier = Modifier.height(spacing20))
                Row {
                    CatalogShoesItem(
                        title = "Спортивные", width = 174.dp, height = 277.dp,
                        image = tandapp.icons.R.drawable.img_sports_shoes,
                        backgroundColor = Color(0xFFA93006),
                        alignment = Alignment.BottomStart
                    )
                    Spacer(modifier = Modifier.width(spacing16))
                    Column {
                        CatalogShoesItem(
                            title = "Кеды",
                            width = 174.dp,
                            height = 132.dp,
                            image = tandapp.icons.R.drawable.img_catalog_sneakers,
                            backgroundColor = Color(0xFF5A372D),
                            alignment = Alignment.TopStart
                        )
                        Spacer(modifier = Modifier.height(spacing14))
                        CatalogShoesItem(
                            title = "Женские",
                            width = 174.dp,
                            height = 132.dp,
                            image = tandapp.icons.R.drawable.img_woman,
                            backgroundColor = Color(0xFFCAA9B9),
                            alignment = Alignment.TopStart
                        )
                    }
                }
                Spacer(modifier = Modifier.height(spacing12))
            }
        },
        bottomBar = {
            CustomBottomNavigation(
                navController = navController,
                scope = scope,
                onNavClick = { itemDest ->
                    scope.launch {

                    }
                }
            )
        }
    )
}

@Composable
fun CatalogShoesItem(
    title: String,
    @DrawableRes image: Int = tandapp.icons.R.drawable.img_fashion,
    height: Dp,
    width: Dp,
    backgroundColor: Color = Color.Black,
    alignment: Alignment = Alignment.TopEnd
) {
    Box(modifier = Modifier.clip(RoundedCornerShape(cornerRadius10))) {
        Text(
            text = title,
            fontSize = fontSize10,
            lineHeight = lineHeight10,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            modifier = Modifier
                .align(alignment)
                .zIndex(1f)
                .padding(horizontal = spacing8, vertical = spacing10)
                .background(backgroundColor, shape = RoundedCornerShape(cornerRadius4))
                .padding(horizontal = spacing8, vertical = spacing4)
        )
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(height)
                .width(width)
        )
    }
}
