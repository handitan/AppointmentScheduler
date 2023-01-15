package com.example.appointmentscheduler.ui.add_appointment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.appointmentscheduler.ui.add_appointment.components.AddAppointmentContent
import com.example.appointmentscheduler.ui.appointments.AppointmentViewModel
import com.example.appointmentscheduler.ui.update_appointment.components.UpdateAppointmentContent

@Composable
fun AddAppointmentScreen(
    apptViewModel: AppointmentViewModel,
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
            ) {
                Text(text = "New appointment")
            }
        },
        content = { paddingValues ->
            AddAppointmentContent(
                addAppt = { appt ->
                    apptViewModel.addAppointment(appt)
                },
                navigateBack = navigateBack
            )
        }
    )
}