package com.ranzan.toastimpl.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ranzan.toastimpl.model.Network
import kotlinx.coroutines.Dispatchers

class TheViewModel : ViewModel() {

    fun getData() = liveData(Dispatchers.IO) {
        emit(Network.apiService.getData(1).data)

    }
}
