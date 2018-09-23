package com.ignition.testproject.di.modules

import com.ignition.testproject.BuildConfig
import com.ignition.testproject.datasources.network.GetPlacesAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()

    @Provides
    @Singleton
    fun providePlacesApi(retrofit: Retrofit) = retrofit.create(GetPlacesAPI::class.java)
}