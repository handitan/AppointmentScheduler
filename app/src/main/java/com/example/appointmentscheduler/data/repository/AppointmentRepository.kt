package com.example.appointmentscheduler.data.repository

import com.example.appointmentscheduler.data.model.Appointment
import com.example.appointmentscheduler.data.network.AppointmentDao

class AppointmentRepository(
    private val appointmentDao: AppointmentDao
) {
    fun getAppointmentsFromRoom() = appointmentDao.getAppointments()
    fun deleteAppointmentFromRoom(appt: Appointment) = appointmentDao.deleteAppointment(appt)
    //TODO HANDI
}