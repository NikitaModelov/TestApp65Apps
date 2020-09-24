package ru.modelov.testapp65apps

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.modelov.testapp65apps.listemployees.di.EmployeesModule
import ru.modelov.testapp65apps.listspecialties.di.SpecialtiesModule
import ru.modelov.testapp65apps.main.network.di.NetworkModules

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(NetworkModules)
            modules(SpecialtiesModule)
            modules(EmployeesModule)
        }
    }
}