package com.thomson.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColourPicker(currentColour: CurrentColour) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(align = Alignment.Center)
            .padding(8.dp)
    ) {
        ColourItem(color = Color.Blue, selected = currentColour)
        ColourItem(color = Color.Red, selected = currentColour)
        ColourItem(color = Color.Green, selected = currentColour)
        ColourItem(color = Color(0xFFFFA100), selected = currentColour)
        ColourItem(color = Color.White, selected = currentColour)
        ColourItem(color = Color.Black, selected = currentColour)
        ColourItem(color = Color.Cyan, selected = currentColour)
        ColourItem(color = Color(0xFFFF2987), selected = currentColour)
        ColourItem(color = Color(0xFF8D1647), selected = currentColour)
        ColourItem(color = Color.DarkGray, selected = currentColour)
        ColourItem(color = Color.Magenta, selected = currentColour)
        ColourItem(color = Color.Yellow, selected = currentColour)
    }
}

@Composable
fun ColourItem(color: Color, selected: CurrentColour) {
    val borderColor = if (selected.color.value == color) Color.LightGray else Color.Transparent
    Box(modifier = Modifier
        .size(32.dp)
        .padding(3.dp)
        .background(color)
        .border(2.dp, borderColor)
        .clickable { selected.color.value = color }) {
    }
}

/*@Preview
@Composable
fun ColourPickerPreview() {
    ColourPicker(CurrentColour())
}*/

data class CurrentColour(
    val color: MutableState<Color> = mutableStateOf(Color.Black)
)