package tandapp.catalogmodule.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import tandapp.catalogmodule.models.ShoeColorModel

class ProductCardViewModel() : ViewModel() {
    val shoesSizes = listOf<String>("36", "37", "38", "39", "40")

    val shoesColors = listOf(
        ShoeColorModel(
            id = 1,
            color = Color.Black,
            title = "Черный"
        ),
        ShoeColorModel(
            id = 2,
            color = Color.Gray,
            title = "Серый"
        ),
        ShoeColorModel(
            id = 3,
            color = Color.Blue,
            title = "Голубой"
        )
    )

    val selectedSize: MutableState<String> = mutableStateOf(shoesSizes[0])
    val selectedColor: MutableState<Int> = mutableStateOf(shoesColors[0].id)

}