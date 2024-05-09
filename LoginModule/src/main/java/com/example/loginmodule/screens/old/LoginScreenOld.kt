package com.example.loginmodule.screens.old

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.loginmodule.viewmodels.LoginViewModel
import org.koin.androidx.compose.getViewModel
import tandapp.utillibrary.buttons.CustomButton
import tandapp.utillibrary.buttons.CustomButtonText
import tandapp.utillibrary.click
import tandapp.utillibrary.textfields.DefaultTextField
import tandapp.utillibrary.values.Gray
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.fontSize14
import tandapp.utillibrary.values.fontSize32
import tandapp.utillibrary.values.lineHeight24
import tandapp.utillibrary.values.spacing140
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing24
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing40
import tandapp.utillibrary.values.spacing8

@Composable
fun LoginScreenOld(
    onForgotPasswordClick: () -> Unit,
    onLoginClick: () -> Unit,
    onRegistrationClick: () -> Unit,
    viewModel: LoginViewModel = getViewModel()
) {
    val showPassword = remember { mutableStateOf(false) }
    val emailFocusRequester = FocusRequester()
    val passwordFocusRequester = FocusRequester()
    Scaffold(
        backgroundColor = Color.White,
        modifier = Modifier.fillMaxSize(),
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
                    focusRequester = emailFocusRequester)

                Spacer(Modifier.height(spacing8))

                Text(
                    text = "Пароль",
                    fontSize = fontSize14,
                    lineHeight = lineHeight24,
                    color = Color.Black
                )

                Spacer(Modifier.height(spacing8))

                DefaultTextField(
                    value = viewModel.password.value.orEmpty(),
                    hint = "Введите пароль",
                    onValueChange = viewModel::onPasswordChange,
                    focusRequester = passwordFocusRequester,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    visualTransformation = if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = tandapp.icons.R.drawable.ic_password_hide),
                            contentDescription = null,
                            tint = Gray,
                            modifier = Modifier
                                .size(24.dp)
                                .click {
                                    showPassword.value = !showPassword.value
                                }
                        )
                    },
                )

                Spacer(Modifier.height(spacing8))

                CustomButton(
                    buttonColors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = Color.Blue
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    enabled = true,
                    onButtonClicked = onForgotPasswordClick,
                    content = {
                        Row(
                            horizontalArrangement = Arrangement.End
                        ) {
                            CustomButtonText(
                                text = "Забыли пароль?",
                                color = Color.Blue,
                                horizontalArrangement = Arrangement.End
                            )
                        }
                    }
                )

                Spacer(Modifier.height(spacing16))
            }
        },
        bottomBar = {
            Column {
                CustomButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = spacing16),
                    enabled = true,
                    onButtonClicked = {},
                    content = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CustomButtonText(
                                text = "Войти",
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(spacing4))
                CustomButton(
                    buttonColors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = Purple
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = spacing16, end = spacing16, bottom = spacing16),
                    enabled = true,
                    onButtonClicked = onRegistrationClick,
                    content = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CustomButtonText(
                                text = "Зарегистрироваться",
                                color = Purple
                            )
                        }
                    }
                )
            }
        }
    )
}