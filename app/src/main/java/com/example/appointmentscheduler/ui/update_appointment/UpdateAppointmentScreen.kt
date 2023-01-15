package com.example.appointmentscheduler.ui.update_appointment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.appointmentscheduler.ui.appointments.AppointmentViewModel
import com.example.appointmentscheduler.ui.update_appointment.components.UpdateAppointmentContent

@Composable
fun UpdateAppointmentScreen(
    apptViewModel: AppointmentViewModel,
    apptId:Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        apptViewModel.getAppointment(apptId)
    }

    Scaffold(
        topBar = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
            ) {
                Text(text = "Update your appointment")
            }
        },
        content = { paddingValues ->  
            UpdateAppointmentContent(
                appt = apptViewModel.appt,
                updateAppt = { appt ->
                    apptViewModel.updateAppointment(appt)
                },
                updateDate = { date ->
                    apptViewModel.updateDate(date)
                },
                updateTime = { time ->
                    apptViewModel.updateTime(time)
                },
                updateLoc = { loc ->
                     apptViewModel.updateLocation(loc)
                },
                updateDesc = { desc ->
                    apptViewModel.updateDescription(desc)
                },
                navigateBack = navigateBack
            )
        }
    )
}