package com.example.loginmodule.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.loginmodule.viewmodels.RegistrationViewModel
import org.koin.androidx.compose.getViewModel
import tandapp.icons.R
import tandapp.utillibrary.buttons.CustomButton
import tandapp.utillibrary.buttons.CustomButtonText
import tandapp.utillibrary.click
import tandapp.utillibrary.textfields.DefaultTextField
import tandapp.utillibrary.values.Gray
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.fontSize13
import tandapp.utillibrary.values.fontSize14
import tandapp.utillibrary.values.fontSize32
import tandapp.utillibrary.values.lineHeight18
import tandapp.utillibrary.values.lineHeight24
import tandapp.utillibrary.values.spacing140
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing24
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing40
import tandapp.utillibrary.values.spacing8

@Composable
fun RegistrationScreen(
    onBackClick: () -> Unit,
    onSubmitClick: () -> Unit,
    viewModel: RegistrationViewModel = getViewModel()
) {
    val emailFocusRequester = FocusRequester()
    val passwordFocusRequester = FocusRequester()
    val repeatPasswordFocusRequester = FocusRequester()
    Scaffold(
        backgroundColor = Color.White,
        modifier = Modifier.fillMaxSize(),
        topBar = {
//            DefaultToolbar(
//                onBackClick = onBackClick,
//                title = "Назад",
//            )
        },
        content = {
            it.calculateTopPadding()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = spacing140,
                        start = spacing24,
                        end = spacing24,
                        bottom = spacing24
                    ),
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "TANDApp",
                        lineHeight = lineHeight24,
                        fontSize = fontSize32,
                        textAlign = TextAlign.Center,
                        color = Purple,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(Modifier.height(spacing40))

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

                Spacer(Modifier.height(spacing8))

                Text(
                    text = "Пароль (8 или более символов)",
                    fontSize = fontSize14,
                    lineHeight = lineHeight24,
                    color = Color.Black
                )

                Spacer(Modifier.height(spacing8))

                DefaultTextField(
                    value = viewModel.password.value,
                    hint = "Введите пароль",
                    onValueChange = viewModel::onPasswordChange,
                    focusRequester = passwordFocusRequester,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                )

                Spacer(Modifier.height(spacing8))

                Text(
                    text = "Повторите пароль",
                    fontSize = fontSize14,
                    lineHeight = lineHeight24,
                    color = Color.Black
                )

                Spacer(Modifier.height(spacing8))

                DefaultTextField(
                    value = viewModel.repeatPassword.value,
                    hint = "Повторите пароль",
                    onValueChange = viewModel::onRepeatPasswordChange,
                    focusRequester = repeatPasswordFocusRequester,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                )

                Spacer(Modifier.height(spacing8))

                Text(
                    text = "Нажимая «Согласиться и присоединиться», \n" +
                            "вы cоглашаетесь с условиями обработки \n" +
                            "персональных данных.",
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
                                text = "Согласиться и продолжить",
                            )
                        }
                    }
                )
            }
        }
    )
}