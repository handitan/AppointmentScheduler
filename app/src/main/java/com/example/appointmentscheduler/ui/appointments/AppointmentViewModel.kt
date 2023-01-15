package com.example.appointmentscheduler.ui.appointments

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

    var appt:Appointment by mutableStateOf(Appointment(date = "", time = "", location = "", description = ""))
        private set

    val apptList = apptRepo.getAppointmentsFromRoom()

    fun getAppointment(id:Int) {
        viewModelScope.launch(Dispatchers.IO) {
            appt = apptRepo.getAppointmentFromRoom(id)
        }
    }

    fun updateAppointment(appt:Appointment) {
        viewModelScope.launch(Dispatchers.IO) {
            apptRepo.updateAppointmentFromRoom(appt)
        }
    }

    fun deleteAppointment(appt: Appointment) {
        viewModelScope.launch(Dispatchers.IO) {
            apptRepo.deleteAppointmentFromRoom(appt)
        }
    }

    fun updateDate(date:String) {
        appt = appt?.copy(date = date)
    }

    fun updateTime(time:String) {
        appt = appt?.copy(time = time)
    }

    fun updateLocation(location:String) {
        appt = appt?.copy(location = location)
    }

    fun updateDescription(description:String) {
        appt = appt?.copy(description = description)
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