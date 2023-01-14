package com.example.appointmentscheduler

import android.app.Application
import com.example.appointmentscheduler.data.network.AppointmentDao
import com.example.appointmentscheduler.data.network.AppointmentDb
import com.example.appointmentscheduler.data.repository.AppointmentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class AppointmentApplication: Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy {
        AppointmentDb.getInstance(this, applicationScope)
    }

    val apptRepo by lazy {
        AppointmentRepository(database.appointmentDao())
    }
}