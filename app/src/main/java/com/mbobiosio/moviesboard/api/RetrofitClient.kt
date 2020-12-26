package com.mbobiosio.moviesboard.api

import com.mbobiosio.moviesboard.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().apply {
            addHeader(
                "Authorization",
                "Bearer ${BuildConfig.API_KEY}"
            )
        }.build()
        return chain.proceed(request)
    }
}

object RetrofitClient {
    val apiService by lazy { retrofitService<APIService>() }
}

private fun httpClient(): OkHttpClient {

    val interceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    return OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
        this.addInterceptor(HeaderInterceptor())

    }.build()

}

private fun getMoshi(): Moshi {
    return Moshi.Builder().apply {
        this.add(KotlinJsonAdapterFactory())
    }.build()
}

private fun getRetrofit(): Retrofit {
    return Retrofit.Builder().apply {
        client(httpClient())
        baseUrl(BuildConfig.BASE_URL)
        addConverterFactory(MoshiConverterFactory.create(getMoshi()))
    }.build()
}

private inline fun <reified T> retrofitService(): T = getRetrofit().create(T::class.java)
