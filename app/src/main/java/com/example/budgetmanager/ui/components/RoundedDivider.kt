package com.example.budgetmanager.ui.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp


@Composable
fun RoundedDivider(modifier: Modifier) {
    Divider(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp)
            .fillMaxHeight()
            .width(3.dp)
            .clip(shape = RoundedCornerShape(10.dp))
    )
}