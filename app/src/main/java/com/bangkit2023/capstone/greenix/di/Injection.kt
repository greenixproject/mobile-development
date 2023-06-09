package com.bangkit2023.capstone.greenix.di

import android.content.Context
import com.bangkit2023.capstone.greenix.data.repository.Repository
import com.bangkit2023.capstone.greenix.data.source.remote.ApiConfig

object Injection {
    fun provideRepository(context: Context) : Repository {
        val apiService = ApiConfig.apiService()
        return Repository(apiService, context)
    }
}