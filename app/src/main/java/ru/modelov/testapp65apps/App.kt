package ru.modelov.testapp65apps

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.modelov.testapp65apps.feature.employee.detailemployee.di.DetailEmployeeModule
import ru.modelov.testapp65apps.feature.employee.listemployees.di.EmployeesModule
import ru.modelov.testapp65apps.feature.specialties.list.di.SpecialtiesModule
import ru.modelov.testapp65apps.main.network.di.NetworkModules

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(NetworkModules)
            modules(SpecialtiesModule)
            modules(EmployeesModule)
            modules(DetailEmployeeModule)
        }
    }
}