package edu.uksw.fti.pam.pam_activityintent.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.uksw.fti.pam.pam_activityintent.repositories.JSONPlaceholderTypicodeRepository
import kotlinx.coroutines.launch

class ApparelViewModel : ViewModel() {
    private var _apparelList = mutableStateListOf<ApparelModel>()

    var errorMessage: String by mutableStateOf("")
    val apparelList: List<ApparelModel>
        get() = _apparelList

    fun getApparelList() {
        viewModelScope.launch {
            val apiClient = JSONPlaceholderTypicodeRepository.getClient()
            try {
                _apparelList.clear()
                _apparelList.addAll(apiClient.getApparel())
            }
            catch (e: Exception) {
                errorMessage = e.message!!
            }
        }
    }
}