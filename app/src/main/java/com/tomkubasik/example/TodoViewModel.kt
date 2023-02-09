package com.tomkubasik.example

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tomkubasik.example.domain.model.Task
import com.tomkubasik.example.domain.repository.TaskRepository
import com.tomkubasik.example.model.UiTask
import com.tomkubasik.example.model.toUiTask
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val taskRepository: TaskRepository
) : ViewModel() {

    val tasks: StateFlow<List<UiTask>> = taskRepository.getAll().map {
        it.map(Task::toUiTask)
    }.stateIn(viewModelScope, SharingStarted.Eagerly, listOf())

    fun addTask() {
        viewModelScope.launch {
            taskRepository.insert(
                Task(UUID.randomUUID().toString(), isDone = false, description = "insert nouvelle tache")
            )
        }
    }
}