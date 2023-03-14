package edu.uksw.fti.pam.pam_activityintent.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.uksw.fti.pam.pam_activityintent.repositories.JSONPlaceholderTypicodeRepository
import kotlinx.coroutines.launch

class PartsViewModel : ViewModel() {
    private var _partsList = mutableStateListOf<PartsModel>()

    var errorMessage: String by mutableStateOf("")
    val partsList: List<PartsModel>
        get() = _partsList

    fun getPartsList() {
        viewModelScope.launch {
            val apiClient = JSONPlaceholderTypicodeRepository.getClient()
            try {
                _partsList.clear()
                _partsList.addAll(apiClient.getParts())
            }
            catch (e: Exception) {
                errorMessage = e.message!!
            }
        }
    }
}