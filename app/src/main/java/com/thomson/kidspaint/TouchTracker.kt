package com.thomson.kidspaint

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun TouchTracker(value: PaintItemsList) {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.Transparent)
        .pointerInput(Unit) {
            detectDragGestures(onDragStart = { offset ->
                value.items.add(
                    PaintData(
                        LineProperties(
                            value.selectedColour.color.value,
                            value.selectedThickness.thickness.value
                        ), mutableListOf(offset)
                    )
                )
                value.action.value = System.currentTimeMillis()
            }, onDragEnd = {
            }, onDrag = { change, _ ->
                value.items.last().points.add(change.position)
                value.action.value = change.uptimeMillis
            })
        }) {

    }
}