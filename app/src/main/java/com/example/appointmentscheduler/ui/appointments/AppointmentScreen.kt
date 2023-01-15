package com.example.appointmentscheduler.ui.appointments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.ui.graphics.Color
import com.example.appointmentscheduler.core.Constants
import com.example.appointmentscheduler.data.model.Appointment
import com.example.appointmentscheduler.ui.appointments.components.AppointmentCard

@Composable
fun AppointmentScreen(
    apptViewModel: AppointmentViewModel,
    navigateToAddAppointmentScreen: () -> Unit,
    navigateToUpdateAppointmentScreen: (apptId: Int) -> Unit
) {
    val appointmentList by apptViewModel.apptList.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        topBar = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                ) {
                Text(text = "Your appointments")
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navigateToAddAppointmentScreen()}) {
                Icon(Icons.Rounded.Add, contentDescription = Constants.ADD)
            }
        }
    ){
        LazyColumn (modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)){
            items(appointmentList, key = { appt -> appt.id}) {
                AppointmentCard(appt = it,
                    deleteAppt = { apptViewModel.deleteAppointment(it) },
                    updateAppt = { navigateToUpdateAppointmentScreen(it.id) }
                )
            }
        }
    }

}