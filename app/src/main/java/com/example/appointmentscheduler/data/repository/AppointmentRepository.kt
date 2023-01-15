package com.example.appointmentscheduler.data.repository

import com.example.appointmentscheduler.data.model.Appointment
import com.example.appointmentscheduler.data.network.AppointmentDao

class AppointmentRepository(
    private val appointmentDao: AppointmentDao
) {
    fun getAppointmentsFromRoom() = appointmentDao.getAppointments()
    fun getAppointmentFromRoom(id:Int) = appointmentDao.getAppointment(id)
    fun updateAppointmentFromRoom(appt:Appointment) = appointmentDao.updateAppointment(appt)
    fun deleteAppointmentFromRoom(appt: Appointment) = appointmentDao.deleteAppointment(appt)
    fun addAppointmentIntoRoom(appt:Appointment) = appointmentDao.addAppointment(appt)
}