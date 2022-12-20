package com.cerminnovations.moviesboard.di

import com.cerminnovations.core.constant.Constants
import com.cerminnovations.core.constant.Constants.CONN_TIMEOUT
import com.cerminnovations.core.util.network.ConnectionInterceptor
import com.cerminnovations.core.util.network.ConnectionObserver
import com.cerminnovations.moviesboard.BuildConfig
import com.cerminnovations.moviesboard.data.remote.api.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideConnectionInterceptor(
        connectionObserver: ConnectionObserver,
    ): ConnectionInterceptor =
        ConnectionInterceptor(connectionObserver)

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = when {
                BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
                else -> HttpLoggingInterceptor.Level.NONE
            }
        }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        connectionInterceptor: ConnectionInterceptor,
    ): OkHttpClient = OkHttpClient.Builder().apply {
        connectTimeout(CONN_TIMEOUT, TimeUnit.SECONDS)
        readTimeout(CONN_TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(CONN_TIMEOUT, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            addInterceptor(httpLoggingInterceptor)
        }
        addInterceptor(connectionInterceptor)
    }.build()

    // Retrofit for networking
    @Provides
    @Singleton
    fun provideRetrofit(
        moshi: Moshi,
        okHttpClient: OkHttpClient,
        baseUrl: String,
    ): Retrofit =
        Retrofit.Builder().apply {
            baseUrl(baseUrl)
            client(okHttpClient)
            addConverterFactory(MoshiConverterFactory.create(moshi))
        }.build()

    // Provide Moshi
    @Singleton
    @Provides
    fun provideMoshi(): Moshi =
        Moshi.Builder().apply {
            addLast(KotlinJsonAdapterFactory())
        }.build()

    @Provides
    @Singleton
    fun provideApiService(
        retrofit: Retrofit,
    ): ApiService = retrofit.create(ApiService::class.java)
}
