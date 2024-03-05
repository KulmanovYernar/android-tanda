package tandapp.utillibrary.toolbars

import android.widget.GridLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import tandapp.utillibrary.R
import tandapp.utillibrary.buttons.BackButton
import tandapp.utillibrary.values.fontSize16
import tandapp.utillibrary.values.fontSize22
import tandapp.utillibrary.values.lineHeight22
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing4

@Composable
fun DefaultHomeToolbar(
    title: String = "",
    city: String = "",
    onCityClick: () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(top = spacing4, bottom = spacing4)
    ) {
        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
        Row {

            Icon(
                imageVector = ImageVector.vectorResource(tandapp.icons.R.drawable.ic_tanda),
                contentDescription = null,
                tint = Color.White
            )

            if (title.isNotEmpty()) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = spacing16),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = title,
                        fontSize = fontSize22,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Алматы >",
                fontSize = fontSize16,
                lineHeight = lineHeight22,
                color = Color.Black
            )
            
//            Icon(imageVector = ImageVector.vectorResource(R.drawable.), contentDescription = )
        }
    }
}