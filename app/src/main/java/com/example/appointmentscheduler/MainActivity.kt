package com.example.appointmentscheduler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.appointmentscheduler.navigation.NavGraph
import com.example.appointmentscheduler.navigation.Screen
import com.example.appointmentscheduler.ui.appointments.AppointmentModelFactory
import com.example.appointmentscheduler.ui.appointments.AppointmentScreen
import com.example.appointmentscheduler.ui.appointments.AppointmentViewModel
import com.example.appointmentscheduler.ui.theme.AppointmentSchedulerTheme

class MainActivity : ComponentActivity() {
    private val apptViewModel: AppointmentViewModel by viewModels {
        AppointmentModelFactory(application as AppointmentApplication)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.background(Color.Black)) {
                NavGraph(apptViewModel = apptViewModel, navController = rememberNavController())
            }
        }
    }
}