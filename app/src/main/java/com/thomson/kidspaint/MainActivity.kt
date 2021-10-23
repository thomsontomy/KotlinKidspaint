package com.thomson.kidspaint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.thomson.kidspaint.ui.theme.KotlinKidspaintTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
            KotlinKidspaintTheme {
                // A surface container using the 'background' color from the theme
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
        }
    }
}
