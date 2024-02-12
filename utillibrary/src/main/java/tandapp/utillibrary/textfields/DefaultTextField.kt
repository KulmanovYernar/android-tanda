package tandapp.utillibrary.textfields

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import tandapp.utillibrary.values.Silver
import tandapp.utillibrary.values.cornerRadius16
import tandapp.utillibrary.values.cornerRadius6
import tandapp.utillibrary.values.fontSize16
import tandapp.utillibrary.values.lineHeight22

@Composable
fun DefaultTextField(
    modifier: Modifier = Modifier,
    value: String,
    hint: String,
    focusRequester: FocusRequester? = null,
    singleLine: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onDoneClick: () -> Unit = { },
    onValueChange: (String) -> Unit,
    onFocusChanged: ((FocusState) -> Unit)? = null,
    focusedBorderColor: Color = Color.Green,
    unfocusedBorderColor: Color = Silver,
    trailingIcon: @Composable (() -> Unit)? = null,
    onTrailingIconClick: () -> Unit = { onValueChange("") },
    isError: Boolean = false,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    shape: Shape = RoundedCornerShape(cornerRadius6)
) {
    var colorOfFocus by remember { mutableStateOf(focusedBorderColor) }
    var borderColor by remember { mutableStateOf(unfocusedBorderColor) }
    var isFocused by remember { mutableStateOf(false) }

    val onFocusChangedDefaultCallback by remember {
        mutableStateOf(onFocusChanged ?: { isFocused = it.isFocused })
    }

    LaunchedEffect(key1 = isError, isFocused) {
        colorOfFocus = if (isError) Color.Red else focusedBorderColor
        borderColor = if (isFocused) colorOfFocus else if(isError) Color.Red else unfocusedBorderColor
    }

//    val defaultTrailingIcon: @Composable () -> Unit = trailingIcon
//        ?: { DefaultTrailingIcon(onTrailingIconClick = onTrailingIconClick, showIcon = value.isNotEmpty() && isFocused) }


    var defaultTextFieldModifier = modifier
        .clip(shape = shape)
        .background(color = Color.White)
        .border(1.dp, color = borderColor, shape = shape)
        .fillMaxWidth()
        .onFocusChanged(onFocusChanged = {
            isFocused = it.isFocused
            onFocusChangedDefaultCallback(it)
        })

    if (focusRequester != null) {
        defaultTextFieldModifier = defaultTextFieldModifier.focusRequester(focusRequester)
    }

    TextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        maxLines = if (singleLine) 1 else Int.MAX_VALUE,
        singleLine = singleLine,
        modifier = defaultTextFieldModifier,
        colors = defaultTextFieldColors(cursorColor = colorOfFocus),
        placeholder = {
            Text(
                text = hint,
//                style = regular.copy(
//                    color = Base500,
//                    fontSize = fontSize16,
//                    lineHeight = lineHeight22
//                ),
                color = Color.Gray,
                fontSize = fontSize16,
                lineHeight = lineHeight22,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = KeyboardActions(
            onDone = {
                onDoneClick()
            },
            onNext = {
                onDoneClick()
            }
        ),
        visualTransformation = visualTransformation,
        textStyle = TextStyle.Default.copy(
            color = Color.Black,
            fontSize = fontSize16,
            lineHeight = lineHeight22
        ),
//        trailingIcon = { defaultTrailingIcon() },
        enabled = enabled,
        readOnly = readOnly
    )
}