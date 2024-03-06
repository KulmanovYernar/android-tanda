package tandapp.homemodule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Recommendations() {
    LazyVerticalGrid(columns = GridCells.Fixed(3), content = {
        items(4) {
            RecommendationItem()
        }
    })
}

@Composable
fun RecommendationItem() {
    Box(modifier = Modifier.background(color = Color.White)) {

    }
}