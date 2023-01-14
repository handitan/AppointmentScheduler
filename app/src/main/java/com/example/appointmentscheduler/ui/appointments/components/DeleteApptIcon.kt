package com.example.appointmentscheduler.ui.appointments.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import com.example.appointmentscheduler.core.Constants.Companion.DELETE_APPOINTMENT

@Composable
fun DeleteApptIcon(
    deleteAppt: () -> Unit
) {
    IconButton(
        onClick = deleteAppt
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = DELETE_APPOINTMENT
        )
    }
}