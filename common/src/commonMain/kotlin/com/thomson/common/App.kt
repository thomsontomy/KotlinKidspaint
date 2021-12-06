package com.thomson.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun App() {
    val selectedColour = CurrentColour()
    val selectedThickness = CurrentThickness()
    val paintData = remember {
        mutableStateOf(
            PaintItemsList(
                selectedColour = selectedColour,
                selectedThickness = selectedThickness
            )
        )
    }

    Surface(color = MaterialTheme.colors.background) {
        TouchTracker(paintData.value)
        PaintCanvas(paintData.value)
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            ColourPicker(currentColour = selectedColour)
            ToolsPanel(paintData.value)
            LineThicknessPanel(selectedThickness = selectedThickness)
        }
    }
}