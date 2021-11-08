package com.my.basiccodelab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.my.basiccodelab2.ui.theme.BasicCodelab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCodelab2Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                    GreetingWithPadding("Test with padding")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Compasable
fun GreetingWithPadding(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicCodelab2Theme {
        Greeting("Android")
    }
}