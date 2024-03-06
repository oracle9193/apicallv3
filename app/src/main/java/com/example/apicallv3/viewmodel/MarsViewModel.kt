package com.example.apicallv3.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicallv3.network.MarsApi
import kotlinx.coroutines.launch

class MarsViewModel: ViewModel() {

    var marsUiState: String by mutableStateOf("")
        private set


    init {
        getMarsList()
    }
    fun getMarsList() {
        //  marsUiState = "Set the Mars API status response here!"
        viewModelScope.launch {
            val listResult = MarsApi.retrofitService.getPhotos()
            marsUiState = listResult
        }
    }
}