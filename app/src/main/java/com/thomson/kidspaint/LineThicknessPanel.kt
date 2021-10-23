package com.thomson.kidspaint

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LineThicknessPanel(selectedThickness: CurrentThickness) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .padding(8.dp)
    ) {
        ThicknessItem(thickness = 2f, selected = selectedThickness)
        ThicknessItem(thickness = 6f, selected = selectedThickness)
        ThicknessItem(thickness = 10f, selected = selectedThickness)
        ThicknessItem(thickness = 14f, selected = selectedThickness)
        ThicknessItem(thickness = 20f, selected = selectedThickness)
        ThicknessItem(thickness = 28f, selected = selectedThickness)
    }
}

@Composable
fun ThicknessItem(thickness: Float, selected: CurrentThickness) {
    val borderColor =
        if (selected.thickness.value == thickness) Color.DarkGray else Color.Transparent
    Box(modifier = Modifier
        .size(32.dp)
        .padding(3.dp)
        .border(2.dp, borderColor)
        .padding(1.dp)
        .border(1.dp, Color.LightGray)
        .clickable { selected.thickness.value = thickness }, contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.padding(1.dp), onDraw = {
            drawLine(
                Color.Red,
                start = Offset.Zero,
                end = Offset(23f, 23f),
                strokeWidth = thickness
            )
        })
    }
}

data class CurrentThickness(
    val thickness: MutableState<Float> = mutableStateOf(2f)
)

@Preview
@Composable
fun LineThicknessPanelPreview() {
    LineThicknessPanel(CurrentThickness())
}