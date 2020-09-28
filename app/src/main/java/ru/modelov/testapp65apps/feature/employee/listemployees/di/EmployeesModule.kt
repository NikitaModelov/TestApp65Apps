package ru.modelov.testapp65apps.feature.employee.listemployees.di

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.modelov.testapp65apps.feature.employee.listemployees.data.api.EmployeesApi
import ru.modelov.testapp65apps.feature.employee.listemployees.data.database.EmployeesDatabase
import ru.modelov.testapp65apps.feature.employee.listemployees.data.datasource.EmployeesLocalDataSource
import ru.modelov.testapp65apps.feature.employee.listemployees.data.datasource.EmployeesLocalDataSourceImpl
import ru.modelov.testapp65apps.feature.employee.listemployees.data.datasource.EmployeesRemoteDataSource
import ru.modelov.testapp65apps.feature.employee.listemployees.data.datasource.EmployeesRemoteDataSourceImpl
import ru.modelov.testapp65apps.feature.employee.listemployees.data.repository.EmployeesRepositoryImpl
import ru.modelov.testapp65apps.feature.employee.listemployees.domain.repository.EmployeesRepository
import ru.modelov.testapp65apps.feature.employee.listemployees.domain.usecase.GetEmployeesUseCase
import ru.modelov.testapp65apps.feature.employee.listemployees.presentation.EmployeesViewModel
import ru.modelov.testapp65apps.main.network.di.createRetrofitService
import ru.modelov.testapp65apps.main.storage.di.provideDatabase
import ru.modelov.testapp65apps.main.storage.values.DatabaseName

private val viewModelModule = module {
    viewModel { (id: Long) ->
        EmployeesViewModel(idSpecialty = id, getEmployeesUseCase = get())
    }
}

private val repositoryModule = module {
    factory<EmployeesRepository> {
        EmployeesRepositoryImpl(
            get(),
            get()
        )
    }
}

private val dataSourceModule = module {
    single<EmployeesRemoteDataSource> {
        EmployeesRemoteDataSourceImpl(
            get()
        )
    }
    single<EmployeesLocalDataSource> {
        EmployeesLocalDataSourceImpl(get())
    }
}
private val useCaseModule = module {
    single { GetEmployeesUseCase(get()) }
}

private val retrofitModule = module {
    factory { createRetrofitService<EmployeesApi>(get()) }
}

private val databaseModule = module {
    single {
        provideDatabase<EmployeesDatabase>(
            androidContext(),
            DatabaseName.EMPLOYEES_STORAGE
        )
    }
}

val EmployeesModule = listOf(
    viewModelModule,
    repositoryModule,
    dataSourceModule,
    useCaseModule,
    databaseModule,
    retrofitModule
)