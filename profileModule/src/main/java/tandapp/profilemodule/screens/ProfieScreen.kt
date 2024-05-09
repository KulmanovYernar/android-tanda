package tandapp.profilemodule.screens

import android.os.Build
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import tandapp.icons.R
import tandapp.navigationmodule.CustomBottomNavigation
import tandapp.navigationmodule.destinations.LoginDestinations
import tandapp.profilemodule.viewmodels.ProfileViewModel
import tandapp.utillibrary.buttons.CustomButton
import tandapp.utillibrary.buttons.CustomButtonText
import tandapp.utillibrary.click
import tandapp.utillibrary.textfields.DefaultTextField
import tandapp.utillibrary.toolbars.DefaultToolbarWithEditButton
import tandapp.utillibrary.ui_components.BoxImage
import tandapp.utillibrary.values.Gray
import tandapp.utillibrary.values.Silver3
import tandapp.utillibrary.values.Silver4
import tandapp.utillibrary.values.cornerRadius10
import tandapp.utillibrary.values.cornerRadius20
import tandapp.utillibrary.values.cornerRadius24
import tandapp.utillibrary.values.fontSize13
import tandapp.utillibrary.values.fontSize14
import tandapp.utillibrary.values.fontSize16
import tandapp.utillibrary.values.lineHeight20
import tandapp.utillibrary.values.lineHeight24
import tandapp.utillibrary.values.spacing10
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing2
import tandapp.utillibrary.values.spacing20
import tandapp.utillibrary.values.spacing24
import tandapp.utillibrary.values.spacing28
import tandapp.utillibrary.values.spacing32
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing52
import tandapp.utillibrary.values.spacing8
import tandapp.utils.SharedPreferencesHelper
import tandapp.utils.permissions.RequestMediaPermission

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun ProfileScreen(
    navController: NavController,
    onBack: (String?) -> Unit = {},
    viewModel: ProfileViewModel = getViewModel()
) {
    val registered by SharedPreferencesHelper.onLogged.collectAsStateWithLifecycle()

    Log.d("TAG", "ProfileScreen: $registered")
    val route = navController.currentBackStackEntry?.destination?.route
//    BackHandler {
//        onBack(route)
//    }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val showBottomSheet = remember {
        mutableStateOf(false)
    }
    val uploadImageClick = remember {
        mutableStateOf(false)
    }
    val onChangeData = remember {
        mutableStateOf(false)
    }

    val firstNameFocusReq = remember {
        mutableStateOf(FocusRequester())
    }

    val lastNameFocusReq = remember {
        mutableStateOf(FocusRequester())
    }

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { result ->
            result?.let { uri ->
//                val file = File(uri.path.orEmpty())
//                val inputData = context.contentResolver.openInputStream(uri)?.readBytes()
//                val base = Base64.encodeToString(inputData, Base64.NO_WRAP)
                // to file
                // to base64
                val s = viewModel.fileFromContentUri(context, uri)
                Log.d("imagePickerLauncher", "URI: $uri")
//                viewModel.uploadProfileImage(
//                    file = s
//                )
            }
            uploadImageClick.value = false
            showBottomSheet.value = false
        }
    )

    if (uploadImageClick.value) {
        RequestMediaPermission(
            onPermissionDenied = {},
            onPermissionGranted = {
                imagePickerLauncher.launch(PickVisualMediaRequest(mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly))
            }
        )
    }

    Scaffold(
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            if (registered == true) {
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
                            buttonText = if (onChangeData.value) "Готово" else "Изменить",
                            titleColor = Color.Black,
                            onEditClick = {
                                onChangeData.value = true
                            },
                            onCompleteClick = {
                                onChangeData.value = false
                                viewModel.updateProfileInfo()
                            },
                            onChangeData = onChangeData.value,
                        )
                    }
                }
            }
        },
        content = {
            if (registered == true) {
                if (onChangeData.value) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = spacing16)
                    ) {
                        Text(
                            text = "First Name",
                            fontSize = fontSize14,
                            lineHeight = lineHeight24,
                            color = Color.Black
                        )

                        Spacer(Modifier.height(spacing8))

                        DefaultTextField(
                            value = viewModel.firstName.value,
                            hint = "First Name",
                            onValueChange = viewModel::onFirstNameChange,
                            singleLine = true,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Email,
                                imeAction = ImeAction.Next
                            ),
                            focusRequester = firstNameFocusReq.value
                        )

                        Spacer(Modifier.height(spacing8))

                        Text(
                            text = "Last Name",
                            fontSize = fontSize14,
                            lineHeight = lineHeight24,
                            color = Color.Black
                        )

                        Spacer(Modifier.height(spacing8))

                        DefaultTextField(
                            value = viewModel.lastName.value.orEmpty(),
                            hint = "Last Name",
                            onValueChange = viewModel::onLastNameChange,
                            focusRequester = lastNameFocusReq.value,
                            singleLine = true,
                        )
                    }
                } else {
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
                            BoxImage(
                                imageRes = R.drawable.ic_profile,
                                boxSize = 45.dp,
                                cornerRadius = cornerRadius24,
                                maxHeight = 25.dp,
                                maxWidth = 25.dp
                            )
                            Spacer(modifier = Modifier.width(spacing4))
                            Column(verticalArrangement = Arrangement.spacedBy(spacing2)) {
                                Text(
                                    text = viewModel.profileInfo.value?.firstName.orEmpty() + " " + viewModel.profileInfo.value?.lastName,
                                    fontSize = fontSize16,
                                    lineHeight = lineHeight24,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Medium
                                )

                                Text(
                                    text = viewModel.profileInfo.value?.email.orEmpty(),
                                    fontSize = fontSize13,
                                    lineHeight = lineHeight20,
                                    color = Color.Blue,
                                    fontWeight = FontWeight.Normal
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(spacing24))
                        Column(verticalArrangement = Arrangement.spacedBy(spacing20)) {
                            ChangeProfilePhoto(onClick = {
                                uploadImageClick.value = true
                            })
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
                        LogOut(onLogOutClick = {
                            SharedPreferencesHelper.clear()
                        })
                        Spacer(modifier = Modifier.height(spacing32))
                    }
                }
            } else {
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
                        painter = painterResource(id = tandapp.icons.R.drawable.img_profile_not_registered),
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
                        text = "После входа вам будут доступны товары с персональными скидками",
                        style = TextStyle(
                            fontSize = fontSize13,
                            lineHeight = 18.sp,
                            fontWeight = FontWeight(400),
                            color = Silver3,
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

                    Spacer(modifier = Modifier.height(160.dp))

                    Text(
                        text = "О приложении",
                        style = TextStyle(
                            fontSize = fontSize13,
                            lineHeight = 18.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF8D68F0),
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier.click {

                        }
                    )

                    Spacer(modifier = Modifier.height(spacing16))

                    Text(
                        text = "Информация для клиентов",
                        style = TextStyle(
                            fontSize = fontSize13,
                            lineHeight = 18.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF8D68F0),
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier.click {

                        }
                    )
                }
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
fun ChangeProfilePhoto(onClick: () -> Unit) {
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
fun LogOut(onLogOutClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                0.5.dp, color = Silver3, shape = RoundedCornerShape(
                    cornerRadius10
                )
            )
            .padding(horizontal = spacing16, vertical = spacing10)
            .click { onLogOutClick() },
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