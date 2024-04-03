package com.example.loginmodule.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import tandapp.icons.R
import tandapp.utillibrary.click
import tandapp.utillibrary.values.Base100
import tandapp.utillibrary.values.Silver5
import tandapp.utillibrary.values.fontSize14
import tandapp.utillibrary.values.fontSize20
import tandapp.utillibrary.values.lineHeight18
import tandapp.utillibrary.values.lineHeight24
import tandapp.utillibrary.values.spacing12
import tandapp.utillibrary.values.spacing120
import tandapp.utillibrary.values.spacing20
import tandapp.utillibrary.values.spacing24

@Composable
fun ConfirmOtpScreen(
    navController: NavController,
    confirmType: String = "",
    processInstanceId: String = "",
    onBackClick: () -> Unit,
    onSuccess: () -> Unit,
) {

    BackHandler {
        onBackClick()
    }

    val loading = remember {
        mutableStateOf(false)
    }

    val error = remember {
        mutableStateOf(false)
    }

    val errorTitle = remember {
        mutableStateOf("")
    }

    val errorDescription = remember {
        mutableStateOf("")
    }


//    if (error.value) {
//        CustomAlertDialogOneButton(
//            title = errorTitle.value,
//            description = errorDescription.value,
//            descriptionMaxLines = 8,
//            positiveButtonText = stringResource(id = R.string.ok),
//            positiveButtonColor = Green500,
//            positiveButtonClick = {
//                error.value = false
//                onBackClick()
//            },
//            onDismissRequest = {
//                error.value = false
//                onBackClick()
//            }
//        )
//    }

    if (!loading.value) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Base100)
                .padding(horizontal = spacing24),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = spacing20)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_close),
                    contentDescription = null,
                    tint = Silver5,
                    modifier = Modifier
                        .size(24.dp)
                        .click {
                            onBackClick()
                        }
                )
            }

            Spacer(modifier = Modifier.height(spacing120))

            Text(
                text = "Введите код",
                color = Color.Black,
                fontSize = fontSize20,
                lineHeight = lineHeight24,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(spacing12))

            Text(
                text = "Код подтверждения отправлен на yernar0709@gmail.com",
                color = Silver5,
                fontSize = fontSize14,
                lineHeight = lineHeight18,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )

            ConfirmCodeScreen(
                title = "Код-подтверждения",
                processInstanceId = processInstanceId,
                description = "Введите 4-значный код из уведомления",
                success = {
                    loading.value = true
                },
                backgroundColor = Base100
            )
        }
    } else {
//        Loading()
    }
}
