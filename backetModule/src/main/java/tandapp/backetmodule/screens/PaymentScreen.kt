package tandapp.backetmodule.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.compose.getViewModel
import tandapp.backetmodule.viewmodels.PaymentViewModel
import tandapp.utillibrary.buttons.CustomButton
import tandapp.utillibrary.buttons.CustomButtonText
import tandapp.utillibrary.toolbars.DefaultToolbarWithRightIcon
import tandapp.utillibrary.values.Base100
import tandapp.utillibrary.values.Base50
import tandapp.utillibrary.values.Green500
import tandapp.utillibrary.values.cornerRadius12
import tandapp.utillibrary.values.fontSize13
import tandapp.utillibrary.values.fontSize16
import tandapp.utillibrary.values.lineHeight18
import tandapp.utillibrary.values.lineHeight22
import tandapp.utillibrary.values.spacing12
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing18
import tandapp.utillibrary.values.spacing24
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing8

@Composable
fun PaymentScreen(
    onBackClick: () -> Unit,
//    viewModel: PaymentViewModel = getViewModel()
) {


    Scaffold(
        modifier = Modifier
            .padding(horizontal = spacing16)
            .background(Base100),
        topBar = {
            DefaultToolbarWithRightIcon(onBackClick = onBackClick, buttonText = "Назад")
        },
        bottomBar = {
            CustomButton(
                modifier = Modifier
                    .height(40.dp),
                content = {
                    CustomButtonText(text = "Перейти к оплате")
                },
                onButtonClicked = {}
            )
            Spacer(modifier = Modifier.height(spacing24))
        }
    ) {
        it.calculateBottomPadding()
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Spacer(modifier = Modifier.height(spacing24))
            }
            item {
                DeliveryItem()
            }
            item {
                Spacer(modifier = Modifier.height(spacing8))
            }

        }

    }
}


@Composable
fun DeliveryItem() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(
            Base50, shape = RoundedCornerShape(
                cornerRadius12
            )
        )) {
        Text(
            text = "Пункт выдачи",
            fontSize = fontSize16,
            lineHeight = lineHeight22,
            fontWeight = FontWeight(500),
            color = Color.Black,
        )

        Spacer(modifier = Modifier.height(spacing4))

        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = tandapp.icons.R.drawable.img_delivery_card),
                contentDescription = null,
                modifier = Modifier
                    .width(60.dp)
                    .height(45.dp)
            )
            Spacer(modifier = Modifier.width(spacing12))
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Алматы, Байтурсынова 42/1",
                    fontSize = fontSize13,
                    lineHeight = lineHeight18,
                    fontWeight = FontWeight(500),
                    color = Color.Black,
                )

                Text(text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = fontSize13,
                            color = Color.Black,

                            )
                    ) {
                        append("Доставка: ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = fontSize13,
                            color = Green500,
                        )
                    ) {
                        append("Бесплатная")
                    }
                })
            }
        }
    }
}


@Composable
@Preview(showSystemUi = true)
fun PaymentPreview(){
    PaymentScreen(onBackClick = { /*TODO*/ })
}