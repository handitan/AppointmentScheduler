package com.example.appointmentscheduler.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appointmentscheduler.core.Constants.Companion.APPOINTMENT_TABLE

@Entity(tableName = APPOINTMENT_TABLE)
data class Appointment(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: String,
    val time: String,
    val location:String,
    val description: String
)