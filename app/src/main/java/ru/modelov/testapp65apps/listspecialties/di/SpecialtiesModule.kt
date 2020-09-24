package ru.modelov.testapp65apps.listspecialties.di

import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import ru.modelov.testapp65apps.listspecialties.data.api.SpecialtiesApi
import ru.modelov.testapp65apps.listspecialties.data.datasource.SpecialtiesDataSource
import ru.modelov.testapp65apps.listspecialties.data.datasource.SpecialtiesRemoteDataSource
import ru.modelov.testapp65apps.listspecialties.data.repository.SpecialtiesRepositoryImpl
import ru.modelov.testapp65apps.listspecialties.domain.repository.SpecialtiesRepository
import ru.modelov.testapp65apps.listspecialties.presentation.SpecialtiesViewModel
import ru.modelov.testapp65apps.main.network.di.createRetrofitService

private val viewModelModule = module {
    viewModel {
        SpecialtiesViewModel(get())
    }
}

private val repositoryModule = module {
    factory<SpecialtiesRepository> {
        SpecialtiesRepositoryImpl(
            get()
        )
    }
}

private val dataSourceModule = module {
    single<SpecialtiesDataSource> {
        SpecialtiesRemoteDataSource(
            get()
        )
    }
}

private val retrofitModule = module {
    factory { createRetrofitService<SpecialtiesApi>(get()) }
}

val SpecialtiesModule = listOf(
    viewModelModule,
    repositoryModule,
    dataSourceModule,
    retrofitModule
)