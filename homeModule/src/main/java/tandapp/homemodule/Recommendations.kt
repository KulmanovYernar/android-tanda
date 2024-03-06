package tandapp.homemodule

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import tandapp.utillibrary.values.Silver3
import tandapp.utillibrary.values.fontSize10
import tandapp.utillibrary.values.lineHeight10
import tandapp.utillibrary.values.lineHeight13
import tandapp.utillibrary.values.spacing12
import tandapp.utillibrary.values.spacing2
import tandapp.utillibrary.values.spacing20
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing64
import tandapp.utillibrary.values.spacing8

@Composable
fun Recommendations() {
    LazyVerticalGrid(
        contentPadding = PaddingValues(bottom = spacing64),
        horizontalArrangement = Arrangement.spacedBy(spacing12),
        verticalArrangement = Arrangement.spacedBy(spacing20),
        columns = GridCells.Fixed(3),
        content = {
            items(16) {
                RecommendationItem()
            }
        })
}

@Composable
private fun RecommendationItem() {
    Box(
        modifier = Modifier
            .background(color = Color.White)
            .height(180.dp)
            .width(107.dp)
            .padding(horizontal = spacing4)
    ) {
        Icon(
            painter = painterResource(id = tandapp.icons.R.drawable.ic_like),
            contentDescription = null,
            tint = Silver3,
            modifier = Modifier
                .size(22.dp)
                .align(Alignment.TopEnd)
                .offset(x = (-6).dp, y = 10.dp)
                .zIndex(1f)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = spacing4)
        ) {
            Image(
                painter = painterResource(id = tandapp.icons.R.drawable.img_sneakers),
                contentDescription = null,
                modifier = Modifier
                    .width(90.dp)
                    .height(120.dp)
            )

            Spacer(modifier = Modifier.height(spacing4))

            Text(
                text = "Кроссовки Pierre Cardin",
                color = Color.Black,
                fontSize = fontSize10,
                lineHeight = lineHeight10
            )

            Spacer(modifier = Modifier.height(spacing8))

            Row {
                Text(
                    text = "44 990 ₸",
                    color = Color.Black,
                    fontSize = fontSize10,
                    lineHeight = lineHeight13
                )
                Spacer(modifier = Modifier.width(spacing2))
                Text(
                    text = "49 990 ₸",
                    color = Color.Black,
                    fontSize = fontSize10,
                    lineHeight = lineHeight13,
                    style = TextStyle(textDecoration = TextDecoration.LineThrough)
                )
            }
        }
    }
}