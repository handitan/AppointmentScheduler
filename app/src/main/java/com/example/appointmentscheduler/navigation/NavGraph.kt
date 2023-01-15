package com.example.appointmentscheduler.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.appointmentscheduler.navigation.Screen.*
import com.example.appointmentscheduler.ui.add_appointment.AddAppointmentScreen
import com.example.appointmentscheduler.ui.appointments.AppointmentScreen
import com.example.appointmentscheduler.ui.appointments.AppointmentViewModel
import com.example.appointmentscheduler.ui.update_appointment.UpdateAppointmentScreen

@Composable
fun NavGraph(
    apptViewModel: AppointmentViewModel,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AppointmentScreen.route
    ) {
        composable(route = AppointmentScreen.route) {
            AppointmentScreen(
                apptViewModel = apptViewModel,
                navigateToAddAppointmentScreen = {
                    navController.navigate(AddAppointmentScreen.route)
                },
                navigateToUpdateAppointmentScreen = { apptId ->
                    navController.navigate(UpdateAppointmentScreen.route + "/$apptId")
            })
        }
        composable(route = UpdateAppointmentScreen.route + "/{apptId}"
            ,arguments = listOf(
                navArgument("apptId") {
                    type = NavType.IntType
                }
            )) { it ->
            val apptId = it.arguments?.getInt("apptId",0) ?: 0
            UpdateAppointmentScreen(
                apptViewModel = apptViewModel,
                apptId = apptId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = AddAppointmentScreen.route
            ) { it ->
            AddAppointmentScreen(
                apptViewModel = apptViewModel,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}