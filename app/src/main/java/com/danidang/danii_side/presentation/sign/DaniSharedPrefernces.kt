package com.danidang.danii_side.presentation.sign

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.danidang.danii_side.BuildConfig

class DaniSharedPrefernces(context: Context) {
    private val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val dataStore: SharedPreferences =
        if (BuildConfig.DEBUG) context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        else EncryptedSharedPreferences.create(
            context,
            FILE_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

    var isLogin: Boolean
        set(value) = dataStore.edit { putBoolean(IS_LOGIN, value) }
        get() = dataStore.getBoolean(IS_LOGIN, false)

    companion object {
        const val FILE_NAME = "DaniSharedPreferences"
        const val IS_LOGIN = "IsLogin"
    }
}