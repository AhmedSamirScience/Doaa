package com.samirislamic.doaa._02_di

import com.samirislamic.doaa._01_common._01_constants.Constants
import com.samirislamic.doaa._03_data._02_remote._01_apiService.MainApi
import com.samirislamic.doaa._03_data._03_repository.MainRepositoryImpl
import com.samirislamic.doaa._04_domain._01_repository.remote.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
 import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    //region OkHttpClient
    /**
     * Provided OkHttpClient for all Nav graphs
     */

    // Creates a logging interceptor and sets it to log the body of HTTP requests and responses
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(Constants.TIME_OUt, TimeUnit.SECONDS).readTimeout(Constants.TIME_OUt, TimeUnit.SECONDS)
            .writeTimeout(Constants.TIME_OUt, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor) // Adds the logging interceptor for HTTP request and response logging
            .build()
    }
    //endregion

    //region API Auth
    /**
     * API Auth (Api Services)
     */
    @Provides
    @Singleton
    fun provideAuthApi(client: OkHttpClient): MainApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(MainApi::class.java)
    }
    /**
     * Domain Layer Repos (UseCases)
     */
    @Provides
    @Singleton
    fun provideAuthRepository(api: MainApi): MainRepository {
        return MainRepositoryImpl(api = api)
    }
    //endregion
}