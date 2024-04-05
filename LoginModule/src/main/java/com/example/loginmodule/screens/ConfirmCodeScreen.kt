package com.example.loginmodule.screens

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.loginmodule.viewmodels.ConfirmCodeViewModel
import org.koin.androidx.compose.getViewModel
import tandapp.utillibrary.text.ResponsiveText
import tandapp.utillibrary.values.Base200
import tandapp.utillibrary.values.Base50
import tandapp.utillibrary.values.Base700
import tandapp.utillibrary.values.Base900
import tandapp.utillibrary.values.Green500
import tandapp.utillibrary.values.cornerRadius16
import tandapp.utillibrary.values.cornerRadius8
import tandapp.utillibrary.values.fontSize13
import tandapp.utillibrary.values.fontSize14
import tandapp.utillibrary.values.fontSize22
import tandapp.utillibrary.values.lineHeight18
import tandapp.utillibrary.values.lineHeight20
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing32
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing8

private const val defaultResendTime = 60000L
private const val defaultErrorResendTime = 1800000L

@Composable
fun ConfirmCodeScreen(
    title: String = "",
    description: String = "",
    processInstanceId: String = "",
    bundle: Bundle? = null,
    backgroundColor: Color = Base50,
    success: (phone: String) -> Unit,
    canChangeNumber: Boolean = false,
    onChangeNumberClick: () -> Unit = {},
    confirmCodeViewModel: ConfirmCodeViewModel = getViewModel()
) {

    val invalidCode = "asd"


//    val phone = hidePhoneNumber(phoneNumber)
    val autoOtp = remember {
        mutableStateOf("")
    }
    val focusRequester = remember {
        FocusRequester()
    }

    val resendTotalTime = remember {
        mutableStateOf(defaultResendTime)
    }
    val errorAlertDialog = remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()
    val isTimerRunning by confirmCodeViewModel.isTimerRunning.collectAsState()
    val currentTimerValue by confirmCodeViewModel.timerCurrentValue.collectAsState()

    LaunchedEffect(key1 = true, block = {
        confirmCodeViewModel.startTimer()
    })

//    confirmCodeViewModel.errorMessage.value = invalidCode


//    val codeConfirmed = confirmCodeViewModel.codeConfirmed.observeAsState()
    val focusManager = LocalFocusManager.current


//    initBroadCast { code ->
//        autoOtp.value = code
//        confirmCodeViewModel.checkConfirmCode(
//            code = code,
//            otpType = otpType,
//            processInstanceId = processInstanceId,
//            onError = {
//                confirmCodeViewModel.error.value = true
//                confirmCodeViewModel.showErrorText.value = true
//            }
//        )
//    }
//
//    CommandEffect(confirmCodeViewModel.otpCodeFlow) { otpCode ->
//        if (otpCode.isNotBlank()) {
//            autoOtp.value = otpCode
//            confirmCodeViewModel.checkConfirmCode(
//                code = otpCode,
//                otpType = otpType,
//                processInstanceId = processInstanceId,
//                onError = {
//                    confirmCodeViewModel.error.value = true
//                    confirmCodeViewModel.showErrorText.value = true
//                }
//            )
//        }
//    }

//    if (codeConfirmed.value == true) {
//        LaunchedEffect(key1 = scope) {
//            success(phoneNumber)
//        }
//    }

//    if (confirmCodeViewModel.errorCount.value > 0) {
//        resendTotalTime.value = defaultErrorResendTime
//    }
//    val block = confirmCodeViewModel.errorCount.value >= 3
//
//    if (confirmCodeViewModel.error.value && !block) {
//        LaunchedEffect(key1 = confirmCodeViewModel.error.value) {
//            delay(800)
//            autoOtp.value = ""
//            focusRequester.requestFocus()
//            confirmCodeViewModel.error.value = false
//        }
//    }
//    LaunchedEffect(key1 = block) {
//        if (block) {
//            errorAlertDialog.value = true
//        }
//    }

//
//    keyboardManager.attachKeyboardDismissListener {
//        focusManager.clearFocus()
//    }


    Column(
        modifier = Modifier
            .background(color = backgroundColor)
            .padding(start = spacing16, end = spacing16)
    ) {

//        Text(
//            text = title,
//            fontSize = fontSize28,
////            style = bold,
//            color = Base900
//        )
//        Spacer(modifier = Modifier.padding(top = spacing16))
//        Text(
//            text = description.ifEmpty { "s" },
//            fontSize = fontSize16,
//            color = Color.Black,
////            style = regular
//        )
        if (canChangeNumber) {
            Spacer(modifier = Modifier.padding(top = spacing8))
            Text(
                text = "asd",
//                style = semiBold,
                fontSize = fontSize14,
                color = Color.Green,
                modifier = Modifier.clickable {
                    onChangeNumberClick()
                })
        }
        Spacer(modifier = Modifier.padding(top = spacing32))
        BasicTextField(
            value = autoOtp.value,
            onValueChange = {
                autoOtp.value = it
//                if (confirmCodeViewModel.errorCount.value >= 3) {
//                    return@BasicTextField
//                }
//                if (otpType.size >= it.length) {
//                    autoOtp.value = it
//                    confirmCodeViewModel.error.value = false
//                    confirmCodeViewModel.showErrorText.value = false
//                }
//                if (it.length == otpType.size) {
//                    confirmCodeViewModel.checkConfirmCode(
//                        code = it,
//                        otpType = otpType,
//                        processInstanceId = processInstanceId,
//                        onError = {
//                            confirmCodeViewModel.error.value = true
//                            confirmCodeViewModel.showErrorText.value = true
//                        }
//                    )
//                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            decorationBox = {
                CodeInputDecoration(autoOtp.value, 4, error = false)
            },
            enabled = true,
            modifier = Modifier.focusRequester(focusRequester = focusRequester)
        )
//        AnimatedVisibility(confirmCodeViewModel.showErrorText.value) {
//            Column {
//                Spacer(modifier = Modifier.padding(top = spacing8))
//                Text(
//                    text = confirmCodeViewModel.errorMessage.value,
//                    fontSize = fontSize13,
//                    color = Red700,
//                    style = regular
//                )
//                LaunchedEffect(key1 = Unit, block = {
//                    delay(5000)
//                    confirmCodeViewModel.showErrorText.value = false
//                })
//            }
//        }

        Spacer(modifier = Modifier.padding(top = spacing16))

        ResendOneTimePasswordText(
            timerCurrentValue = currentTimerValue,
            isTimerRunning = isTimerRunning,
            onSendPasswordAgainClick = {
                confirmCodeViewModel.resentCode(processInstanceId = processInstanceId)
            }
        )
    }
//    if (confirmCodeViewModel.status.value == UiStatus.LOADING) Loading()
//    if (errorAlertDialog.value) {
//        CustomAlertDialog(
//            positiveButtonClick = {
//                errorAlertDialog.value = false
//                confirmCodeViewModel.error.value = true
//            },
//            onDismissRequest = {
//                errorAlertDialog.value = false
//                confirmCodeViewModel.error.value = true
//            }
//        )
//    }
    LaunchedEffect(key1 = Unit) {
        focusRequester.requestFocus()
    }
}


@Composable
private fun CodeInputDecoration(code: String, length: Int, error: Boolean) {
    Row(horizontalArrangement = Arrangement.Center) {
        for (i in 0 until length) {
            val text = if (i < code.length) code[i].toString() else ""
            val hasFocus = i == code.length
            CodeEntry(text, error, hasFocus = hasFocus)
            Spacer(modifier = Modifier.width(spacing8))
            if (length == 6 && i == 2) {
                Text(
                    text = "-",
                    fontSize = fontSize22,
                    fontWeight = FontWeight.SemiBold,
                    color = Base700
                )
                Spacer(modifier = Modifier.width(spacing8))
            }
        }
    }
}

@Composable
private fun CodeEntry(text: String, error: Boolean, hasFocus: Boolean) {
    val height = remember {
        mutableStateOf(0.dp)
    }
    val color = remember {
        mutableStateOf(Color.Transparent)
    }
    val localDensity = LocalDensity.current
    val focusManager = LocalFocusManager.current
    if (error) {
//        color.value = Red700
        focusManager.clearFocus(true)
    } else if (hasFocus) {
//        color.value = Green500
    } else {
        color.value = Color.Transparent
    }
//    Box(
//        modifier = Modifier
//            ,
//        contentAlignment = Alignment.Center,
//    ) {
//        val color = animateColorAsState(
//            targetValue = if (text.isEmpty()) Color.Gray.copy(alpha = .8f)
//            else Color.Blue.copy(.8f)
//        )
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(cornerRadius16))
            .background(color = Base200)
            .border(1.dp, color.value, RoundedCornerShape(cornerRadius8))
            .padding(4.dp)
            .widthIn(max = 58.dp, min = 44.dp)
            .height(height = height.value)
            .onGloballyPositioned {
                height.value = 44.dp
            }
    ) {
        ResponsiveText(
            text = text,
            targetTextSizeHeight = fontSize22,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.align(Alignment.Center),
            color = Base900
        )
    }
//        Box(
//            Modifier
//                .align(Alignment.BottomCenter)
//                .padding(start = 6.dp, end = 6.dp, bottom = 8.dp)
//                .height(2.dp)
//                .fillMaxWidth()
//                .background(color.value)
//        )
//    }
}

@Composable
fun ResendOneTimePasswordText(
    timerCurrentValue: String,
    isTimerRunning: Boolean,
    onSendPasswordAgainClick: () -> Unit
) {
    if (isTimerRunning) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(spacing4),
        ) {
            Text(
                text = "Отправить код повторно через",
                color = Base700,
                fontSize = fontSize13,
                lineHeight = lineHeight18
            )

            Text(
                text = timerCurrentValue,
                color = Base700,
                fontSize = fontSize13,
                lineHeight = lineHeight18

            )
        }
    } else {
        Text(
            modifier = Modifier.clickable(onClick = onSendPasswordAgainClick),
            text = "Отправить код повторно",
            color = Green500,
            fontSize = fontSize14,
            lineHeight = lineHeight20
        )
    }
}
