package tandapp.utillibrary

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier

fun Modifier.click(enabled: Boolean = true, onClick: () -> Unit) = clickable(
    interactionSource = androidx.compose.foundation.interaction.MutableInteractionSource(),
    indication = null,
    onClick = onClick,
    enabled = enabled
)

fun Modifier.click(
    clickable: Boolean,
    enabled: Boolean = true,
    onClick: () -> Unit
): Modifier = if (clickable) then(click(enabled, onClick)) else this