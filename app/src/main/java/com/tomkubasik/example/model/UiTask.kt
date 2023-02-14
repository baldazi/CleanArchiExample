package com.tomkubasik.example.model

import androidx.compose.runtime.Stable
import com.tomkubasik.example.domain.model.Task

@Stable
data class UiTask(
    val id: String,
    val done: Boolean,
    val description: String,
)

fun Task.toUiTask() = UiTask(id, isDone, description)
