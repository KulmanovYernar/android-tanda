package com.example.loginmodule.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.loginmodule.viewmodels.LoginViewModel
import org.koin.androidx.compose.getViewModel
import tandapp.utillibrary.buttons.CustomButton
import tandapp.utillibrary.buttons.CustomButtonText
import tandapp.utillibrary.textfields.DefaultTextField
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.fontSize32
import tandapp.utillibrary.values.lineHeight24
import tandapp.utillibrary.values.spacing140
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing24
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing40
import tandapp.utillibrary.values.spacing8

@Composable
fun LoginScreen(
    onForgotPasswordClick: () -> Unit,
    onLoginClick: () -> Unit,
    onRegistrationClick: () -> Unit,
    viewModel: LoginViewModel = getViewModel()
) {
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

                Text(text = "Электронная почта")

                Spacer(Modifier.height(spacing8))

                DefaultTextField(
                    value = "",
                    hint = "Введите свою электронную почту",
                    onValueChange = {}
                )

                Spacer(Modifier.height(spacing8))

                Text(text = "Пароль")

                Spacer(Modifier.height(spacing8))

                DefaultTextField(
                    modifier = Modifier.padding(),
                    value = "",
                    hint = "Введите пароль",
                    onValueChange = {},
//                    trailingIcon = {
//                        Icon(painter = painterResource(id = 0), contentDescription = null)
//                    },
                    onTrailingIconClick = {}
                )

                Spacer(Modifier.height(spacing16))

                CustomButtonText(
                    text = "Забыли пароль?", color = Color.Blue,
                    horizontalArrangement = Arrangement.End
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
                    onButtonClicked = {},
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