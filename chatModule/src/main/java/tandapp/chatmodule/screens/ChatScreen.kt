package tandapp.chatmodule.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import domain.chat.models.MessageBox
import domain.chat.models.MessageType
import org.koin.androidx.compose.getViewModel
import tandapp.chatmodule.MessageItem
import tandapp.chatmodule.R
import tandapp.chatmodule.viewmodels.ChatViewModel
import tandapp.utillibrary.click
import tandapp.utillibrary.toolbars.DefaultChatToolbar
import tandapp.utillibrary.ui_components.BoxImage
import tandapp.utillibrary.values.Base200
import tandapp.utillibrary.values.Base400
import tandapp.utillibrary.values.Base500
import tandapp.utillibrary.values.Base900
import tandapp.utillibrary.values.Green500
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.Silver3
import tandapp.utillibrary.values.Silver4
import tandapp.utillibrary.values.cornerRadius20
import tandapp.utillibrary.values.fontSize16
import tandapp.utillibrary.values.spacing12
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing24
import tandapp.utillibrary.values.spacing8

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChatScreen(
    navController: NavController,
    viewModel: ChatViewModel = getViewModel(),
    onBack: (String?) -> Unit
) {
    val route = navController.currentBackStackEntry?.destination?.route
    BackHandler {
        onBack(route)
    }

    val textFieldValue = remember {
        mutableStateOf(TextFieldValue())
    }

    val messages by viewModel.conversation.collectAsStateWithLifecycle()
    Log.d("ChatScreen", "LazyColumn recomposed. Messages: $messages")
    val scope = rememberCoroutineScope()
//    val lazyListState = rememberForeverLazyListState(key = "main",
//        initialData = viewModel.mainVerticalScrollState.value,
//        scrollStateCallback = viewModel.scrollStateSaveCallback)

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
                    .background(Silver3)
                    .padding(spacing16),
                reverseLayout = true
            ) {
                Log.d("ChatScreen", "LazyColumn recomposed. Messages: $messages")
                items(messages?.size ?: 0) {
                    Log.d("MessageItem", "ChatScreen: $it -- -- ${messages?.get(it)}")
                    MessageItem(messages?.get(it))
                    Log.d("ChatScreen", "LazyColumn recomposed. Messages: $messages")
                    Spacer(modifier = Modifier.height(spacing12))
                }

            }
        },
        bottomBar = {
            Column(modifier = Modifier.background(Color.White)) {
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
                                text = "Type here...",
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