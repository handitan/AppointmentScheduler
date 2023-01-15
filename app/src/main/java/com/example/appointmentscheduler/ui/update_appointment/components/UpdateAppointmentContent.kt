package com.example.appointmentscheduler.ui.update_appointment.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.appointmentscheduler.core.Constants.Companion.UPDATE
import com.example.appointmentscheduler.data.model.Appointment

@Composable
fun UpdateAppointmentContent(
    appt: Appointment,
    updateAppt: (appt:Appointment) -> Unit,
    updateDate: (date:String) -> Unit,
    updateTime: (time:String) -> Unit,
    updateLoc: (loc:String) -> Unit,
    updateDesc: (desc:String) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            modifier = Modifier.background(Color.White),
            value = appt.date,
            onValueChange = {
                    date -> updateDate(date)
            }
        )
        TextField(
            modifier = Modifier.background(Color.White),
            value = appt.time,
            onValueChange = {
                    time -> updateTime(time)
            }
        )
        TextField(
            modifier = Modifier.background(Color.White),
            value = appt.location,
            onValueChange = {
                    loc -> updateLoc(loc)
            }
        )
        TextField(
            modifier = Modifier.background(Color.White).weight(1.0f),
            value = appt.description,
            onValueChange = {
                description -> updateDesc(description)
            }
        )

        Button(onClick = {
            updateAppt(appt)
            navigateBack()
        }) {
            Text(
               text = UPDATE
            )
        }
    }
}