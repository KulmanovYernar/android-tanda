package tandapp.navigationmodule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import tandapp.navigationmodule.destinations.MainDestinations
import tandapp.utillibrary.click
import tandapp.utillibrary.values.Gray
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.fontSize11
import tandapp.utillibrary.values.spacing12
import tandapp.utillibrary.values.spacing2
import tandapp.utillibrary.values.spacing20
import tandapp.utillibrary.values.spacing8

@Composable
fun CustomBottomNavigation(
    navController: NavController,
    scope: CoroutineScope,
    onNavClick: (itemDest: String) -> Unit = {}
) {
    val items = remember {
        listOf(
            MainDestinations.HOME,
            MainDestinations.CATALOG,
            MainDestinations.CHAT,
            MainDestinations.BACKET,
            MainDestinations.PROFILE
        )
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Column {
//        Divider(color = Silver)

        Row(
            modifier = Modifier
                .background(color = Color.White)
        ) {
            items.forEach { item ->
                BottomNavigationItem(
                    selected = currentRoute == item.destination,
                    icon = item.icon,
                    name = stringResource(id = item.title),
                    isChat = item == MainDestinations.CHAT,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        scope.launch {
                            navController.navigate(item.destination) {
//                                onNavClick(item.destination)
                                navController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun BottomNavigationItem(
    icon: Int,
    name: String,
    isChat: Boolean = false,
    selected: Boolean,
    modifier: Modifier,
    onClick: () -> Unit
) {
    if (isChat) {
        Column(
            modifier = modifier
                .offset(y = (-15).dp)
                .click(onClick = onClick),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .background(Purple)
                    .padding(horizontal = spacing20, vertical = spacing12),
            ) {
                Icon(
                    painterResource(id = icon),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp),
                )
                Spacer(modifier = Modifier.height(spacing2))
                Text(
                    text = name,
                    fontSize = fontSize11,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                )
            }
        }
    } else {
        Column(
            modifier = modifier
                .click(onClick = onClick)
                .padding(vertical = spacing8),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(spacing8)
        ) {
            Icon(
                painterResource(id = icon),
                contentDescription = null,
                tint = if (selected) Purple else Gray.copy(0.4f),
                modifier = Modifier.size(28.dp)
            )

            Text(
                text = name,
                fontSize = fontSize11,
                fontWeight = if (selected) FontWeight.Medium else FontWeight.Normal,
//            style = if (selected) medium else regular,
                color = if (selected) Purple else Gray,
            )
        }
    }
}