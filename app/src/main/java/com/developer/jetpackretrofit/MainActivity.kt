package com.developer.jetpackretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewModelScope
import com.developer.jetpackretrofit.model.ViewModelUser
import com.developer.jetpackretrofit.network.MarkApi
import com.developer.jetpackretrofit.ui.theme.JetpackRetrofitTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            JetpackRetrofitTheme {
                val model by viewModels<ViewModelUser>()
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Greeting(model.data)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "$name")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackRetrofitTheme {
        Greeting("")
    }
}
