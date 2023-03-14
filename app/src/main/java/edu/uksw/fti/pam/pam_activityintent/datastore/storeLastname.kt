package edu.uksw.fti.pam.pam_activityintent.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreLastname(private val context: Context) {

    companion object {
        private val Context.dataStoreLname: DataStore<Preferences> by preferencesDataStore("Lastname")
        val USER_LNAME_KEY = stringPreferencesKey("lastname")
    }

    val getLName: Flow<String?> = context.dataStoreLname.data
        .map { preferences ->
            preferences[USER_LNAME_KEY] ?: ""
        }

    suspend fun saveLName(name: String) {
        context.dataStoreLname.edit { preferences ->
            preferences[USER_LNAME_KEY] = name
        }
    }
}