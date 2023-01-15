package com.example.appointmentscheduler.ui.appointments.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import com.example.appointmentscheduler.core.Constants

@Composable
fun EditApptIcon(
    editAppt: () -> Unit
) {
    IconButton(
        onClick = editAppt
    ) {
        Icon(
            imageVector = Icons.Default.Edit,
            contentDescription = Constants.DELETE_APPOINTMENT
        )
    }
}