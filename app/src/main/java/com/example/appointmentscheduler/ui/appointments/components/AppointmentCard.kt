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
    deleteAppt: () -> Unit,
    updateAppt: () -> Unit
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

            //TODO HANDI overflow
            /*
            Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
             */
            Column {
                //Column {
                Text(text = "${appt.date} ${appt.time}")
                Text(text = "${appt.location}")
                Text(
                    text = "${appt.description}",
                    maxLines = 2
                )
                //}
                //Spacer(modifier = Modifier.weight(1.0F,true))
                Row {
                    Spacer(modifier = Modifier.weight(1.0F,true))
                    EditApptIcon(
                        editAppt = updateAppt
                    )
                    Spacer(modifier = Modifier.weight(0.1F))
                    DeleteApptIcon(
                        deleteAppt = deleteAppt
                    )
                }
            }
        }
    }
}