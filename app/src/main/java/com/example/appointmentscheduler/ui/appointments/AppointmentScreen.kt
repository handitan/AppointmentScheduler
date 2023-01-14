package com.example.appointmentscheduler.ui.appointments

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import com.example.appointmentscheduler.ui.appointments.components.AppointmentCard

@Composable
fun AppointmentScreen(
    apptViewModel: AppointmentViewModel
) {
    val appointmentList by apptViewModel.apptList.collectAsState(
        initial = emptyList()
    )

    LazyColumn (modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)){
        items(appointmentList, key = { appt -> appt.id}) {
            AppointmentCard(appt = it, deleteAppt = {apptViewModel.deleteAppointment(it)})
        }
    }
}