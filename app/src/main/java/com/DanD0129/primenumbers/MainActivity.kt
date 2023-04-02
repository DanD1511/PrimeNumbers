package com.DanD0129.primenumbers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWord()
        }
    }
}

@Preview
@Composable

fun HelloWord() {
        Column(modifier = Modifier.fillMaxSize()){
            InfoField(title = "Enter number to check if it is prime")
            InfoField(title = "Enter number oƒ primes to calculate")
        }
    }


@Composable
fun InfoField(
    title: String = "Title"
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
                TextField(modifier = Modifier.weight(0.5f), value = inputNumber.value, onValueChange = {
                    inputNumber.value
                })
                Button(modifier = Modifier.weight(0.5f), onClick = { /*TODO*/ }) {
                    Text("Calculate")
                }
            }
        }
}