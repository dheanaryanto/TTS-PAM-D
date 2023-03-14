package edu.uksw.fti.pam.pam_activityintent.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.uksw.fti.pam.pam_activityintent.repositories.JSONPlaceholderTypicodeRepository
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {
    private var _cartList = mutableStateListOf<CartModel>()

    var errorMessage: String by mutableStateOf("")
    val cartList: List<CartModel>
        get() = _cartList

    fun getCartList() {
        viewModelScope.launch {
            val apiClient = JSONPlaceholderTypicodeRepository.getClient()
            try {
                _cartList.clear()
                _cartList.addAll(apiClient.getCart())
            }
            catch (e: Exception) {
                errorMessage = e.message!!
            }
        }
    }
}