package com.thomson.kidspaint

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap

@Composable
fun PaintCanvas(paintItemsList: PaintItemsList) {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        paintItemsList.action.value.let {
            paintItemsList.items.forEach { paintData ->
                drawPoints(
                    points = paintData.points,
                    pointMode = PointMode.Polygon,
                    color = paintData.lineProperties.color,
                    strokeWidth = paintData.lineProperties.thickness,
                    cap = StrokeCap.Round
                )
            }
        }
    }

}


data class PaintItemsList(
    val action: MutableState<Long> = mutableStateOf(0),
    val items: MutableList<PaintData> = mutableListOf(),
    var selectedColour: CurrentColour,
    var selectedThickness: CurrentThickness
)

data class PaintData(
    val lineProperties: LineProperties,
    val points: MutableList<Offset>
)

data class LineProperties(
    val color: Color,
    val thickness: Float
)