package com.example.appointmentscheduler.data.network

import androidx.room.*
import com.example.appointmentscheduler.core.Constants.Companion.APPOINTMENT_TABLE
import com.example.appointmentscheduler.data.model.Appointment
import kotlinx.coroutines.flow.Flow

@Dao
interface AppointmentDao {
    @Query("SELECT * FROM $APPOINTMENT_TABLE")
    fun getAppointments(): Flow<List<Appointment>>

    @Query("SELECT * FROM $APPOINTMENT_TABLE WHERE id = :id")
    fun getAppointment(id:Int):Appointment

    @Insert
    fun addAppointment(appointment:Appointment)

    @Update
    fun updateAppointment(appointment: Appointment)

    @Delete
    fun deleteAppointment(appointment: Appointment)

    @Query("DELETE FROM $APPOINTMENT_TABLE")
    suspend fun deleteAllAppointment()

}