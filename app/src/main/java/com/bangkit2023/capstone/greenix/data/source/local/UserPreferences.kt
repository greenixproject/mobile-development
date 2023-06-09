package com.bangkit2023.capstone.greenix.data.source.local

import android.content.Context

class UserPreferences(context: Context) {
    private val preference = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun setToken(token: String) {
        with(preference.edit()) {
            putString(TOKEN, token)
            commit()
        }
    }

    fun getToken(): String? {
        return preference.getString(TOKEN, "") ?: ""
    }

    fun deleteToken(){
        with(preference.edit()) {
            clear()
            commit()
        }
    }

    private companion object{
        const val PREF_NAME = ""
        const val TOKEN = ""
    }
}