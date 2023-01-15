package com.example.appointmentscheduler.navigation

import com.example.appointmentscheduler.core.Constants.Companion.ADD_APPOINTMENT_SCREEN
import com.example.appointmentscheduler.core.Constants.Companion.APPOINTMENTS_SCREEN
import com.example.appointmentscheduler.core.Constants.Companion.UPDATE_APPOINTMENT_SCREEN

sealed class Screen(
    val route:String
) {
    object AppointmentScreen:Screen(APPOINTMENTS_SCREEN)
    object UpdateAppointmentScreen:Screen(UPDATE_APPOINTMENT_SCREEN)
    object AddAppointmentScreen:Screen(ADD_APPOINTMENT_SCREEN)
}