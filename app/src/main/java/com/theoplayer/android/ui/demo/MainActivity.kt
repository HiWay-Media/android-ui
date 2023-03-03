package com.theoplayer.android.ui.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.theoplayer.android.api.THEOplayerConfig
import com.theoplayer.android.ui.DefaultUI
import com.theoplayer.android.ui.demo.ui.theme.THEOplayerAndroidUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            THEOplayerAndroidUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(title = {
                                Text(text = "Demo")
                            })
                        },
                        content = { padding ->
                            DefaultUI(
                                modifier = Modifier.padding(padding),
                                config = THEOplayerConfig.Builder().build(),
                                title = "Elephant's Dream"
                            )
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    THEOplayerAndroidUITheme {
        DefaultUI(config = THEOplayerConfig.Builder().build())
    }
}