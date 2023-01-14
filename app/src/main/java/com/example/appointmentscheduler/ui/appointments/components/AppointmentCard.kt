package com.example.appointmentscheduler.ui.appointments.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appointmentscheduler.data.model.Appointment

@Composable
fun AppointmentCard(
    appt:Appointment,
    deleteAppt: () -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp)
        .clickable { },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.Center
            //verticalAlignment = Alignment.CenterVertically,
        ) {

            Row {
                Text(text = "${appt.date} ${appt.time}")
                Spacer(modifier = Modifier.weight(1.0F,true))
                DeleteApptIcon(
                    deleteAppt = deleteAppt
                )
            }

        }
    }
}