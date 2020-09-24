package ru.modelov.testapp65apps.listemployees.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.modelov.testapp65apps.listemployees.data.api.EmployeesApi
import ru.modelov.testapp65apps.listemployees.data.datasource.EmployeesDataSource
import ru.modelov.testapp65apps.listemployees.data.datasource.EmployeesRemoteDataSource
import ru.modelov.testapp65apps.listemployees.data.repository.EmployeesRepositoryImpl
import ru.modelov.testapp65apps.listemployees.domain.repository.EmployeesRepository
import ru.modelov.testapp65apps.listemployees.domain.usecase.GetEmployeesUseCase
import ru.modelov.testapp65apps.listemployees.presentation.EmployeesViewModel
import ru.modelov.testapp65apps.main.network.di.createRetrofitService

private val viewModelModule = module {
    viewModel { (id: Long) ->
        EmployeesViewModel(idSpecialty = id, getEmployeesUseCase = get())
    }
}

private val repositoryModule = module {
    factory<EmployeesRepository> {
        EmployeesRepositoryImpl(
            get()
        )
    }
}

private val dataSourceModule = module {
    single<EmployeesDataSource> {
        EmployeesRemoteDataSource(
            get()
        )
    }
}
private val useCaseModule = module {
    single { GetEmployeesUseCase(get()) }
}

private val retrofitModule = module {
    factory { createRetrofitService<EmployeesApi>(get()) }
}

/*private val databaseModule = module {
    single {
        provideDatabase<SpecialtiesDatabase>(
            androidContext(),
            DatabaseName.SPECIALTIES_STORAGE
        )
    }
}*/


val EmployeesModule = listOf(
    viewModelModule,
    repositoryModule,
    dataSourceModule,
    useCaseModule,
    retrofitModule
)
