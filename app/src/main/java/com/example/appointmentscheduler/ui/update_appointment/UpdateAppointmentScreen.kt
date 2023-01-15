package com.example.appointmentscheduler.ui.update_appointment

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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