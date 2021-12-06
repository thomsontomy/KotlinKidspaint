package com.thomson.desktop

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.thomson.common.App

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KidsPaint") {
        MaterialTheme {
            App()
        }
    }
}