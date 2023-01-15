package com.example.appointmentscheduler.navigation

//import androidx.navigation.NavHost
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.appointmentscheduler.navigation.Screen.*
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
                navigateToUpdateBookScreen = { apptId ->
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
    }
}

/*
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BooksScreen.route
    ) {
        composable(
            route = BooksScreen.route
        ) {
            BooksScreen(
                navigateToUpdateBookScreen = { bookId ->
                    navController.navigate("${UpdateBookScreen.route}/${bookId}")
                }
            )
        }
        composable(
            route = "${UpdateBookScreen.route}/{$BOOK_ID}",
            arguments = listOf(
                navArgument(BOOK_ID) {
                    type = IntType
                }
            )
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getInt(BOOK_ID) ?: 0
            UpdateBookScreen(
                bookId = bookId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}


 */