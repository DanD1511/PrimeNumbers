package com.DanD0129.primenumbers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val primeNoPrime = PrimeNoPrime()
        super.onCreate(savedInstanceState)
        setContent {
            Home(primeNoPrime)
        }
    }
}

@Preview
@Composable

fun Home(
    primeNoPrime: PrimeNoPrime = PrimeNoPrime()
) {
    val textShow = remember { mutableStateOf("") }
    val listResult = remember { mutableStateOf(emptyList<Int>()) }
    val listp = remember { mutableStateOf(emptyList<Int>()) }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(74, 204, 197))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Text(
                    text = "Prime or no Prime?",
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 45.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.font_pnp))
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(550.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Column(
                    modifier = Modifier
                        .align(
                            alignment = Alignment.Center
                        )
                        .padding(bottom = 40.dp)
                ) {
                    InfoField(
                        title = "Enter number to check if it is prime",
                        onButtonClicked = { value ->
                            if (value.isEmpty()) {
                                return@InfoField
                            } else if (value.toInt() == 0) {
                                return@InfoField
                            } else {
                                val isPrime = primeNoPrime.isPrime(value.toInt())
                                textShow.value =
                                    "The number ${if (isPrime) "is" else "is not"} prime"
                            }
                        })
                    InfoField(
                        title = "Enter number oƒ primes to calculate",
                        onButtonClicked = { value ->
                            if (value.isEmpty()) {
                                return@InfoField
                            } else if (value.toInt() == 0) {
                                return@InfoField
                            } else {
                                listResult.value = primeNoPrime.giveMeXPrimes(value.toInt())
                            }
                        })

                    Text(
                        modifier = Modifier
                            .padding(top = 50.dp),
                        text = "Result:",
                        fontSize = 30.sp,
                        fontFamily = FontFamily(Font(R.font.font_pnp))
                    )
                    Text(
                        //modifier = Modifier.align(Alignment.BottomCenter),
                        fontSize = 25.sp,
                        fontFamily = FontFamily(Font(R.font.font_pnp)),
                        text = textShow.value
                    )
                    Text(
                        modifier = Modifier
                            //.align(Alignment.Center)
                            .padding(top = 5.dp)
                            .verticalScroll(rememberScrollState()),
                        fontSize = 25.sp,
                        fontFamily = FontFamily(Font(R.font.font_pnp)),
                        text =
                        if (listResult.value.toString() == listp.value.toString()) ""
                        else "${listResult.value}"
                    )
                }
            }
        }
    }
}

@Composable
fun InfoField(
    title: String = "Title",
    onButtonClicked: (String) -> Unit
) {
    val inputNumber = remember { mutableStateOf("") }
    Column {
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp),
            fontSize = 22.sp,
            fontFamily = FontFamily(Font(R.font.font_pnp)),
            text = title
        )
        Row {
            TextField(
                modifier = Modifier
                    .weight(0.5f)
                    .size(50.dp)
                    .padding(
                        start = 50.dp,
                        end = 20.dp
                    ),
                value = inputNumber.value,
                onValueChange = {
                    inputNumber.value = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            Button(
                modifier = Modifier
                    .weight(0.3f)
                    .padding(end = 25.dp),
                onClick = {
                    onButtonClicked(inputNumber.value)
                }
            ) {
                Icon(
                    Icons.Rounded.ArrowForward,
                    contentDescription = "Send"
                )
            }
        }
    }
}


