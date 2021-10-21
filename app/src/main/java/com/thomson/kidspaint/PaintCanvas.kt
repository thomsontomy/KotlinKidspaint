package com.thomson.kidspaint

import android.util.Log
import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter

@Composable
fun PaintCanvas(paintItemsList: PaintItemsList) {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        paintItemsList.action.value.let {
            paintItemsList.items.forEach { paintData ->
                drawPoints(paintData.points, PointMode.Polygon, paintData.lineProperties.color, 2f)
            }
        }
    }

}


data class PaintItemsList(
    val action: MutableState<Long> = mutableStateOf(0),
    val items: MutableList<PaintData> = mutableListOf()
)

data class PaintData(
    val lineProperties: LineProperties,
    val points: MutableList<Offset>
)

data class LineProperties(
    val color: Color,
    val thickness: Int
)