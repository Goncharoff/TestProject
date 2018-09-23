package com.ignition.testproject.di.modules

import com.ignition.testproject.repositories.NetworkRepository
import com.ignition.testproject.repositories.NetworkRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindNetworkRepository(networkRepository: NetworkRepositoryImpl): NetworkRepository
}