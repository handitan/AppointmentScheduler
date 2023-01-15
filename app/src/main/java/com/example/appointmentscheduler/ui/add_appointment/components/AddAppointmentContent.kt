package com.example.appointmentscheduler.ui.add_appointment.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.appointmentscheduler.core.Constants
import com.example.appointmentscheduler.data.model.Appointment

@Composable
fun AddAppointmentContent(
    addAppt: (appt: Appointment) -> Unit,
    navigateBack: () -> Unit
) {
    var newDate by remember {
        mutableStateOf("")
    }

    var newTime by remember {
        mutableStateOf("")
    }

    var newLoc by remember {
        mutableStateOf("")
    }

    var newDesc by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            modifier = Modifier.background(Color.White),
            value = newDate,
            onValueChange = {
                    it -> newDate = it
            }
        )
        TextField(
            modifier = Modifier.background(Color.White),
            value = newTime,
            onValueChange = {
                    it -> newTime = it
            }
        )
        TextField(
            modifier = Modifier.background(Color.White),
            value = newLoc,
            onValueChange = {
                    it -> newLoc = it
            }
        )
        TextField(
            modifier = Modifier
                .background(Color.White)
                .weight(1.0f),
            value = newDesc,
            onValueChange = {
                    it -> newDesc = it
            }
        )

        Button(onClick = {
            addAppt(Appointment(date = newDate, time =  newTime, location = newLoc, description = newDesc))
            navigateBack()
        }) {
            Text(
                text = Constants.ADD
            )
        }
    }
}