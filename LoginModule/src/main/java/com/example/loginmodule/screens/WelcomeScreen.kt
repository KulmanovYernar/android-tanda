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
import tandapp.utillibrary.buttons.CustomButton
import tandapp.utillibrary.buttons.CustomButtonText
import tandapp.utillibrary.text.ResponsiveText
import tandapp.utillibrary.toolbars.DefaultToolbarWithRightText
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.fontSize11
import tandapp.utillibrary.values.fontSize13
import tandapp.utillibrary.values.fontSize14
import tandapp.utillibrary.values.fontSize28
import tandapp.utillibrary.values.lineHeight18
import tandapp.utillibrary.values.lineHeight24
import tandapp.utillibrary.values.spacing100
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing32
import tandapp.utillibrary.values.spacing40

@Composable
fun WelcomeScreen(
    onBeginClick: () -> Unit
) {

    Scaffold(
        backgroundColor = Color.White,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.padding(top = spacing32)) {
                DefaultToolbarWithRightText(
                    rightText = "Пропустить",
                    onRightTextClick = onBeginClick
                )
            }
        },
        content = {
            it.calculateTopPadding()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = spacing100),
                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            SpanStyle(
                                fontSize = fontSize28,
                                color = Color.Black,
                                fontWeight = FontWeight(600),
                            )
                        ) { append("Добро пожаловать\n\nв ") }
                        withStyle(
                            SpanStyle(
                                fontSize = fontSize28,
                                color = Purple,
                                fontWeight = FontWeight(600),
                            )
                        ) { append("TANDApp") }
                    },
                    lineHeight = lineHeight24,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(spacing40))
                Image(
                    painter = painterResource(tandapp.icons.R.drawable.img_welcome),
                    contentDescription = null,
                    modifier = Modifier.size(175.dp)
                )
                Spacer(Modifier.height(spacing16))
                Text(
                    "Нажимая «Согласиться и присоединиться», \n" +
                            "вы cоглашаетесь с условиями обработки \n" +
                            "персональных данных.",
                    fontSize = fontSize13,
                    lineHeight = lineHeight18,
                    color = Color.Black
                )
                Spacer(Modifier.height(spacing40))

                Box(contentAlignment = Alignment.CenterStart) {
                    ResponsiveText(
                        text = "Полный список функций >",
                        color = Purple,
                        lineHeight = lineHeight24,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight(400),
                        targetTextSizeHeight = fontSize14

                    )
                }
            }
        },
        bottomBar = {
            Column {
                CustomButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(spacing16),
                    enabled = true,
                    onButtonClicked = onBeginClick,
                    content = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CustomButtonText(
                                text = "Начать",
                            )
                        }
                    }
                )
            }
        }
    )
}