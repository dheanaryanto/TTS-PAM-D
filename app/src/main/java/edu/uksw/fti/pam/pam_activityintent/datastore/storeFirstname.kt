package edu.uksw.fti.pam.pam_activityintent.datastore


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreFirstname(private val context: Context) {

    companion object {
        private val Context.dataStoreFname: DataStore<Preferences> by preferencesDataStore("firstName")
        val USER_FNAME_KEY = stringPreferencesKey("firstname")
    }

    val getFName: Flow<String?> = context.dataStoreFname.data
        .map { preferences ->
            preferences[USER_FNAME_KEY] ?: ""
        }

    suspend fun saveFName(name: String) {
        context.dataStoreFname.edit { preferences ->
            preferences[USER_FNAME_KEY] = name
        }
    }
}