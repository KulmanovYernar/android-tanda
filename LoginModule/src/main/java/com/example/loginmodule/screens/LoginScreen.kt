package com.example.loginmodule.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.loginmodule.viewmodels.LoginViewModel
import org.koin.androidx.compose.getViewModel
import tandapp.icons.R
import tandapp.utillibrary.buttons.CustomButton
import tandapp.utillibrary.buttons.CustomButtonText
import tandapp.utillibrary.click
import tandapp.utillibrary.textfields.DefaultTextField
import tandapp.utillibrary.values.Blue1
import tandapp.utillibrary.values.Gray
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.Silver4
import tandapp.utillibrary.values.Silver5
import tandapp.utillibrary.values.fontSize13
import tandapp.utillibrary.values.fontSize14
import tandapp.utillibrary.values.fontSize18
import tandapp.utillibrary.values.lineHeight18
import tandapp.utillibrary.values.lineHeight24
import tandapp.utillibrary.values.spacing12
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing20
import tandapp.utillibrary.values.spacing24
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing52
import tandapp.utillibrary.values.spacing8

@Composable
fun LoginScreen(
    onForgotPasswordClick: () -> Unit,
    onLoginClick: () -> Unit,
    onBack: () -> Unit,
    viewModel: LoginViewModel = getViewModel()
) {
    val showPassword = remember { mutableStateOf(false) }
    val emailFocusRequester = FocusRequester()
    val passwordFocusRequester = FocusRequester()
    BackHandler {
        onBack()
    }
    Scaffold(
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(spacing20)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_close),
                    contentDescription = null,
                    tint = Silver5,
                    modifier = Modifier
                        .size(24.dp)
                        .click {
                            onBack()
                        }
                )
            }
        },
        content = {
            it.calculateTopPadding()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = spacing52,
                        start = spacing24,
                        end = spacing24,
                        bottom = it.calculateBottomPadding()
                    ),
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(tandapp.icons.R.drawable.ic_tanda_app),
                        contentDescription = null,
                        tint = Purple,
                        modifier = Modifier
                            .width(150.dp)
                            .height(32.dp)
                    )
                }
                Spacer(Modifier.height(spacing12))

                Text(
                    text = "Введите свою электронную почту",
                    fontSize = fontSize18,
                    lineHeight = lineHeight24,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal
                )

                if (viewModel.loginWithOtp.value) {
                    Spacer(Modifier.height(spacing16))

                    Text(
                        text = "Отправим код для входа на электронную почту",
                        fontSize = fontSize14,
                        lineHeight = lineHeight18,
                        color = Silver4,
                        fontWeight = FontWeight.Normal
                    )
                }

                Spacer(Modifier.height(spacing8))

                DefaultTextField(
                    value = viewModel.email.value,
                    hint = "Электронная почта",
                    onValueChange = viewModel::onEmailChange,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    focusRequester = emailFocusRequester
                )

                Spacer(Modifier.height(spacing8))

                if (!viewModel.loginWithOtp.value) {
                    Text(
                        text = "Пароль",
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
                        visualTransformation = if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_password_hide),
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
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "Забыли пароль?",
                            color = Color.Blue,
                            fontSize = fontSize13,
                            lineHeight = lineHeight18,
                            modifier = Modifier.click {
                                onForgotPasswordClick()
                            }
                        )
                    }
                }

                Spacer(Modifier.height(spacing16))

                CustomButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    enabled = true,
                    onButtonClicked = onLoginClick,
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
                Spacer(Modifier.height(spacing16))
                Text(
                    text = "Продолжая, вы подтверждаете, что прочитали и согласны с правилами пользования интернет-магазина",
                    fontSize = fontSize14,
                    lineHeight = lineHeight18,
                    color = Silver4,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(spacing16))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(modifier = Modifier.weight(1f, false))
                    Spacer(modifier = Modifier.width(spacing4))
                    Text(
                        text = "или",
                        color = Silver5,
                        fontWeight = FontWeight.Normal,
                        fontSize = fontSize13,
                        lineHeight = lineHeight24
                    )
                    Spacer(modifier = Modifier.width(spacing4))
                    Divider(modifier = Modifier.weight(1f, false))
                }

                Spacer(Modifier.height(spacing16))

                CustomButton(
                    buttonColors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = Color.Blue
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    enabled = true,
                    onButtonClicked = {
                        viewModel.loginWithOtp.value = !viewModel.loginWithOtp.value
                    },
                    content = {
                        Row(
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CustomButtonText(
                                text = if (!viewModel.loginWithOtp.value) "Войти с SMS" else "Войти используя пароль",
                                color = Blue1,
                                horizontalArrangement = Arrangement.Center,
                                fontSize = fontSize18,
                                lineHeight = lineHeight24,
                                fontWeight = FontWeight.Normal,
                            )
                        }
                    }
                )
            }
        }
    )
}