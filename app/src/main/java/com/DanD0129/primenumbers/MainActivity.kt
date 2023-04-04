package com.DanD0129.primenumbers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
    val listResult = remember { mutableStateOf( emptyList<Int>()) }
    val listp = remember { mutableStateOf(emptyList<Int>()) }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.align(
                    alignment = Alignment.Center
                )
            ) {
                InfoField(
                    title = "Enter number to check if it is prime",
                    onButtonClicked = { value ->
                        val isPrime = primeNoPrime.isPrime(value.toInt())
                        textShow.value = "The number ${if (isPrime) "is" else "is not"} prime"
                    })
                InfoField(
                    title = "Enter number oƒ primes to calculate", onButtonClicked = {value ->
                        listResult.value =  primeNoPrime.giveMeXPrimes(value.toInt())
                    })
                Text(
                    text = textShow.value
                )
                Text(
                    text = if(listResult.value.toString() == listp.value.toString()) "" else "The result is \n ${listResult.value}"
                )
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
            text = title
        )
        Row {
            TextField(
                modifier = Modifier.weight(0.8f),
                value = inputNumber.value,
                onValueChange = {
                    inputNumber.value = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = {
                    onButtonClicked(inputNumber.value)
                }
            ) {
                Icon(Icons.Rounded.Send, contentDescription = "Send")
            }
        }
    }
}

