package tandapp.profilemodule.screens

import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import tandapp.navigationmodule.CustomBottomNavigation
import tandapp.utillibrary.click
import tandapp.utillibrary.toolbars.DefaultToolbarWithEditButton
import tandapp.utillibrary.ui_components.BoxImage
import tandapp.utillibrary.values.Silver3
import tandapp.utillibrary.values.Silver4
import tandapp.utillibrary.values.cornerRadius10
import tandapp.utillibrary.values.fontSize13
import tandapp.utillibrary.values.fontSize16
import tandapp.utillibrary.values.lineHeight20
import tandapp.utillibrary.values.lineHeight24
import tandapp.utillibrary.values.spacing10
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing2
import tandapp.utillibrary.values.spacing20
import tandapp.utillibrary.values.spacing24
import tandapp.utillibrary.values.spacing32
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing8

@Composable
fun ProfileScreen(
    navController: NavController,
    onBack: () -> Unit = {}
) {
    BackHandler {
        onBack()
    }

    val scope = rememberCoroutineScope()
    val route = navController.currentBackStackEntry?.destination?.route

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
                    DefaultToolbarWithEditButton(
                        title = "Профиль",
                        titleColor = Color.Black,
                        onEditClick = {}
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = spacing8,
                        bottom = it.calculateBottomPadding(),
                        start = spacing16,
                        end = spacing16
                    )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = tandapp.icons.R.drawable.circle_photo),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .click {

                            }
                    )
                    Spacer(modifier = Modifier.width(spacing4))
                    Column(verticalArrangement = Arrangement.spacedBy(spacing2)) {
                        Text(
                            text = "Murat Altynay",
                            fontSize = fontSize16,
                            lineHeight = lineHeight24,
                            color = Color.Black,
                            fontWeight = FontWeight.Medium
                        )

                        Text(
                            text = "murat@moinak.kz",
                            fontSize = fontSize13,
                            lineHeight = lineHeight20,
                            color = Color.Blue,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
                Spacer(modifier = Modifier.height(spacing24))
                Column(verticalArrangement = Arrangement.spacedBy(spacing20)) {
                    ChangeProfilePhoto(onClick = {})
                    DefaultRowItem(
                        icon = tandapp.icons.R.drawable.language,
                        title = "Язык",
                        hint = "Русский",
                        onClick = {}
                    )
                    DefaultRowItem(
                        icon = tandapp.icons.R.drawable.ic_favorite,
                        title = "Избранные",
                        hint = "24",
                        onClick = {}
                    )
                    DefaultRowItem(
                        icon = tandapp.icons.R.drawable.ic_faq,
                        title = "Tanda App FAQ",
                        onClick = {}
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                LogOut(onLogOutClick = {})
                Spacer(modifier = Modifier.height(spacing32))
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
fun ChangeProfilePhoto(onClick: () -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                0.5.dp, color = Silver3, shape = RoundedCornerShape(
                    cornerRadius10
                )
            )
            .padding(horizontal = spacing16, vertical = spacing10)
            .click {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(tandapp.icons.R.drawable.ic_camera),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color.Blue
        )
        Spacer(modifier = Modifier.width(spacing16))
        Text(
            text = "Изменить фото",
            color = Color.Blue,
            fontSize = fontSize13,
            lineHeight = lineHeight20,
            fontWeight = FontWeight.Normal
        )
    }
}
@Composable
fun DefaultRowItem(
    @DrawableRes icon: Int,
    title: String,
    hint: String = "",
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                0.5.dp, color = Silver3, shape = RoundedCornerShape(
                    cornerRadius10
                )
            )
            .padding(horizontal = spacing16, vertical = spacing10)
            .click {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        BoxImage(
            imageRes = icon,
            boxSize = 24.dp,
            maxWidth = 16.dp,
            maxHeight = 16.dp,
            cornerRadius = 4.dp
        )
        Spacer(modifier = Modifier.width(spacing16))
        Text(
            text = title,
            color = Color.Black,
            fontSize = fontSize13,
            lineHeight = lineHeight20,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.weight(1f))
        if (hint.isNotBlank()) {
            Text(
                text = hint,
                color = Silver4,
                fontSize = fontSize13,
                lineHeight = lineHeight20,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.width(spacing2))
        }
        Icon(
            imageVector = ImageVector.vectorResource(tandapp.icons.R.drawable.ic_arrow_right),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Silver4
        )
    }
}

@Composable
fun LogOut(onLogOutClick:() -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                0.5.dp, color = Silver3, shape = RoundedCornerShape(
                    cornerRadius10
                )
            )
            .padding(horizontal = spacing16, vertical = spacing10),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Log Out",
            color = Color.Red,
            fontSize = fontSize13,
            lineHeight = lineHeight20,
            fontWeight = FontWeight.Normal
        )
    }
}