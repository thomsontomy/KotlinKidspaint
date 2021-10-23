package com.thomson.kidspaint

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun ToolsPanel(paintItems: PaintItemsList) {
    Column(
        modifier = Modifier
            .wrapContentSize()
    ) {
        IconButton(onClick = {
            paintItems.items.clear()
        }) {
            Icon(Icons.Default.Clear, contentDescription = "Clear")
        }
        IconButton(onClick = {
            paintItems.items.removeLastOrNull()
        }) {
            Icon(painterResource(id = R.drawable.ic_baseline_undo_24), contentDescription = "Undo")
        }
    }
}