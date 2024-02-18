package com.example.loginmodule.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import com.example.loginmodule.viewmodels.PasswordRecoveryViewModel
import org.koin.androidx.compose.getViewModel
import tandapp.utillibrary.buttons.CustomButton
import tandapp.utillibrary.buttons.CustomButtonText
import tandapp.utillibrary.textfields.DefaultTextField
import tandapp.utillibrary.toolbars.DefaultToolbar
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.fontSize13
import tandapp.utillibrary.values.fontSize14
import tandapp.utillibrary.values.fontSize32
import tandapp.utillibrary.values.lineHeight18
import tandapp.utillibrary.values.lineHeight24
import tandapp.utillibrary.values.spacing10
import tandapp.utillibrary.values.spacing140
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing24
import tandapp.utillibrary.values.spacing40
import tandapp.utillibrary.values.spacing8

@Composable
fun PasswordRecoveryScreen(
    onBackClick: () -> Unit,
    onSubmitClick: () -> Unit,
    viewModel: PasswordRecoveryViewModel = getViewModel()
) {

    val emailFocusRequester = FocusRequester()
    Scaffold(
        backgroundColor = Color.White,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DefaultToolbar(
                onBackClick = onBackClick,
                buttonText = "Назад",
                title = "Восстановление пароля"
            )
        },
        content = {
            it.calculateTopPadding()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(spacing16),
            ) {


                Text(
                    text = "Электронная почта",
                    fontSize = fontSize14,
                    lineHeight = lineHeight24,
                    color = Color.Black
                )

                Spacer(Modifier.height(spacing8))

                DefaultTextField(
                    value = viewModel.email.value,
                    hint = "Введите свою электронную почту",
                    onValueChange = viewModel::onEmailChange,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    focusRequester = emailFocusRequester,
                )

                Spacer(Modifier.height(spacing10))

                Text(
                    text = "Введите свой адрес электронной почты, и мы отправим вам OTP-код для сброса пароля.",
                    color = Color.Black,
                    fontSize = fontSize13,
                    lineHeight = lineHeight18
                )
            }
        },
        bottomBar = {
            Column(modifier = Modifier.padding(bottom = spacing16)) {
                CustomButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = spacing16),
                    enabled = true,
                    onButtonClicked = onSubmitClick,
                    content = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CustomButtonText(
                                text = "Сбросить пароль",
                            )
                        }
                    }
                )
            }
        }
    )
}