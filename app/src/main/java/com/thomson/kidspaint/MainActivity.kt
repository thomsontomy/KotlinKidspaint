package com.thomson.kidspaint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.thomson.common.App
import com.thomson.kidspaint.ui.theme.KotlinKidspaintTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinKidspaintTheme {
                App()
            }
        }
    }
}
