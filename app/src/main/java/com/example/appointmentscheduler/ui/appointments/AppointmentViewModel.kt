package com.example.appointmentscheduler.ui.appointments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.appointmentscheduler.AppointmentApplication
import com.example.appointmentscheduler.data.model.Appointment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class AppointmentViewModel(application: AppointmentApplication): ViewModel() {
    private val apptRepo by lazy {
        application.apptRepo
    }

    val apptList = apptRepo.getAppointmentsFromRoom()

    fun deleteAppointment(appt: Appointment) {
        viewModelScope.launch(Dispatchers.IO) {
            apptRepo.deleteAppointmentFromRoom(appt)
        }
    }
}

class AppointmentModelFactory(private val application: AppointmentApplication) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppointmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AppointmentViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}