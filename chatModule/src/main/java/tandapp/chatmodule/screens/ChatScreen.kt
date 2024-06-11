package tandapp.chatmodule.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.getViewModel
import tandapp.chatmodule.MessageItem
import tandapp.chatmodule.viewmodels.ChatViewModel
import tandapp.navigationmodule.destinations.CatalogDestinations
import tandapp.navigationmodule.destinations.LoginDestinations
import tandapp.utillibrary.buttons.CustomButton
import tandapp.utillibrary.buttons.CustomButtonText
import tandapp.utillibrary.click
import tandapp.utillibrary.toolbars.DefaultChatToolbar
import tandapp.utillibrary.values.Base200
import tandapp.utillibrary.values.Base400
import tandapp.utillibrary.values.Base900
import tandapp.utillibrary.values.Green500
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.Silver2
import tandapp.utillibrary.values.cornerRadius20
import tandapp.utillibrary.values.fontSize13
import tandapp.utillibrary.values.fontSize16
import tandapp.utillibrary.values.spacing100
import tandapp.utillibrary.values.spacing12
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing20
import tandapp.utillibrary.values.spacing24
import tandapp.utillibrary.values.spacing28
import tandapp.utillibrary.values.spacing52
import tandapp.utillibrary.values.spacing8
import tandapp.utils.SharedPreferencesHelper

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChatScreen(
    navController: NavController,
    viewModel: ChatViewModel = getViewModel(),
    onBack: (String?) -> Unit
) {
    val route = navController.currentBackStackEntry?.destination?.route
    val registered by SharedPreferencesHelper.onLogged.collectAsStateWithLifecycle()
    BackHandler {
        onBack(route)
    }

    val textFieldValue = remember {
        mutableStateOf(TextFieldValue())
    }

    val messages by viewModel.conversation.collectAsStateWithLifecycle()
    Log.d("ChatScreen", "LazyColumn recomposed. Messages: $messages")
    val scope = rememberCoroutineScope()

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 6 })

    Scaffold(
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = spacing8, start = spacing16, end = spacing16, bottom = spacing24)
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    DefaultChatToolbar(
                        onBackClick = { navController.navigateUp() },
                        title = "Tandapp Chat",
                    )
                }
            }
        },
        content = {
            it.calculateTopPadding()
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Silver2)
                    .padding(
                        start = spacing16,
                        end = spacing16,
                        top = spacing16,
                        bottom = it.calculateBottomPadding()
                    ),
                verticalArrangement = Arrangement.spacedBy(spacing16, Alignment.Bottom)
            ) {
                if (registered != true) {
                    item {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(
                                    spacing20
                                )
                                .padding(top = spacing52)
                        ) {
                            Image(
                                painter = painterResource(id = tandapp.icons.R.drawable.img_profile_sign_in),
                                contentDescription = null,
                                modifier = Modifier.size(70.dp)
                            )

                            Spacer(modifier = Modifier.height(spacing28))

                            Text(
                                text = "Войдите в свой профиль",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    lineHeight = 22.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color.Black,
                                )
                            )
                            Spacer(modifier = Modifier.height(spacing16))
                            Text(
                                text = "Войдите в аккаунт, для того, чтобы пользоваться чатом",
                                style = TextStyle(
                                    fontSize = fontSize13,
                                    lineHeight = 18.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                )
                            )
                            Spacer(modifier = Modifier.height(spacing24))

                            CustomButton(
                                modifier = Modifier.fillMaxWidth(),
                                content = {
                                    CustomButtonText(
                                        text = "Войти в профиль",
                                        fontSize = 16.sp,
                                        lineHeight = 24.sp,
                                        fontWeight = FontWeight(500),
                                        color = Color.White,
                                    )
                                }
                            ) {
                                navController.navigate(LoginDestinations.SIGN_IN)
                            }
                            
                            Spacer(modifier = Modifier.height(spacing100))

                        }
                    }
                } else {
                    Log.d("ChatScreen", "LazyColumn recomposed. Messages: $messages")
                    items(messages?.size ?: 0) {
                        MessageItem(
                            model = messages?.get(it),
                            onClickProduct = {
                                navController.currentBackStackEntry?.savedStateHandle?.set(
                                    "productId",
                                    messages?.get(it)?.product?.id
                                )
                                navController.navigate(CatalogDestinations.CATALOG_PRODUCT_CARD_ITEM)
                            }
                        )
                    }
                }
            }
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .imePadding()
                    .padding(top = spacing16)
                    .background(Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = spacing12, horizontal = spacing16),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = textFieldValue.value,
                        onValueChange = {
                            textFieldValue.value = it
                        },
                        modifier = Modifier
                            .weight(1f),
                        placeholder = {
                            Text(
                                text = if(registered != true) "Войдите в аккаунт" else "Type here...",
                                fontSize = fontSize16,
                                fontWeight = FontWeight.Normal,
                                color = Base400
                            )
                        },
                        maxLines = 6,
                        shape = RoundedCornerShape(cornerRadius20),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Base900,
                            backgroundColor = Base200,
                            cursorColor = Green500,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )
                    if (textFieldValue.value.text.isNotBlank()) {
                        Spacer(modifier = Modifier.width(spacing8))
                        Icon(
                            painter = painterResource(id = tandapp.icons.R.drawable.ic_message_send),
                            contentDescription = null,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(40.dp)
                                .background(color = Purple)
                                .padding(spacing8)
                                .click {
                                    viewModel.sendMessage(textFieldValue.value.text)
                                    textFieldValue.value = TextFieldValue()
                                },
                            tint = Color.White
                        )
                    }
                }

            }
        }
    )

}