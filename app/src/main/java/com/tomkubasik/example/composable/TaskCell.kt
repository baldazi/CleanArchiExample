package com.tomkubasik.example.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tomkubasik.example.Constants
import com.tomkubasik.example.model.UiTask

@Composable
fun TaskCell(
    uiTask: UiTask,
    onCheckClick: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier.padding(Constants.Spacing.large)
            .clip(shape = RoundedCornerShape(10.dp))
            .border(BorderStroke(1.dp, Color.Gray))
            .clickable {  },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = uiTask.description,
            modifier = Modifier.weight(1f),
        )
        Spacer(modifier = Modifier.size(Constants.Spacing.large))
        Checkbox(
            checked = uiTask.done,
            onCheckedChange = onCheckClick,
        )
    }
}
