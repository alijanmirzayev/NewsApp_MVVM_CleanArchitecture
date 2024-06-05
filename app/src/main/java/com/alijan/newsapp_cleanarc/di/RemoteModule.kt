package com.alijan.newsapp_cleanarc.di

import com.alijan.newsapp_cleanarc.common.utils.Constant
import com.alijan.newsapp_cleanarc.data.api.APIServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun provideRetrofitClient(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.BASE_URL + Constant.API_VERSION)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiServices(retrofit: Retrofit): APIServices{
        return retrofit.create(APIServices::class.java)
    }

}