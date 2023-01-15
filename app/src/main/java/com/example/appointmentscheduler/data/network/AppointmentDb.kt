package com.example.appointmentscheduler.data.network

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.appointmentscheduler.data.model.Appointment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Appointment::class], version = 2)
abstract class AppointmentDb: RoomDatabase() {
    abstract fun appointmentDao(): AppointmentDao

    //TODO HANDI - remove later tests for testing
    private class AppointmentDbCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            instance?.let { database ->
                scope.launch {
                    var apptDao = database.appointmentDao()

                    apptDao.deleteAllAppointment()

                    // Add sample appts.
                    var apptObj = Appointment(date="01/02/2023",time="09:00", location = "Chicago", description = "Description111Description111Description111Description111Description111Description111Description111Description111Description111Description111Description111Description111Description111Description111Description111Description111Description111Description111Description111")
                    apptDao.addAppointment(apptObj)
                    apptObj = Appointment(date="02/20/2023",time="08:00",location = "San Diego", description = "Description222Description222Description222Description222Description222Description222Description222Description222Description222Description222Description222")
                    apptDao.addAppointment(apptObj)
                }
            }
        }
    }

    companion object {
        private const val DB_NAME = "Appointments-db"
        @Volatile
        private var instance: AppointmentDb? = null

        fun getInstance(
            context: Context,
            scope: CoroutineScope
        ): AppointmentDb {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context, scope).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context, scope: CoroutineScope): AppointmentDb {
            return Room.databaseBuilder(
                context,
                AppointmentDb::class.java,
                DB_NAME
            ).fallbackToDestructiveMigration()
                .addCallback(AppointmentDbCallback(scope))
                .build()
        }
    }
}