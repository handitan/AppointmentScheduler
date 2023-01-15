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
    //TODO HANDI
    LaunchedEffect(Unit) {
        apptViewModel.getAppointment(apptId)
    }

    Scaffold(
        content = { paddingValues ->  
            UpdateAppointmentContent(
                appt = apptViewModel.tempAppt,
                updateAppt = { appt ->
                    apptViewModel.updateAppointment(appt)
                }, updateDesc = { desc ->
                    apptViewModel.updateDescription(desc)
                }, navigateBack = navigateBack
            )
        }
    )
}