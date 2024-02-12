package com.example.loginmodule.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import tandapp.icons.R
import tandapp.utillibrary.buttons.CustomButton
import tandapp.utillibrary.buttons.CustomButtonText
import tandapp.utillibrary.text.ResponsiveText
import tandapp.utillibrary.textfields.DefaultTextField
import tandapp.utillibrary.toolbars.DefaultToolbarWithRightText
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.fontSize13
import tandapp.utillibrary.values.fontSize14
import tandapp.utillibrary.values.fontSize28
import tandapp.utillibrary.values.fontSize32
import tandapp.utillibrary.values.lineHeight18
import tandapp.utillibrary.values.lineHeight24
import tandapp.utillibrary.values.spacing1
import tandapp.utillibrary.values.spacing10
import tandapp.utillibrary.values.spacing100
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing24
import tandapp.utillibrary.values.spacing32
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing40
import tandapp.utillibrary.values.spacing8

@Composable
fun LoginScreen(
    onForgotPasswordClick: () -> Unit,
    onLoginClick: () -> Unit,
    onRegistrationClick: () -> Unit,
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
                        top = spacing100,
                        start = spacing24,
                        end = spacing24,
                        bottom = spacing24
                    ),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
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