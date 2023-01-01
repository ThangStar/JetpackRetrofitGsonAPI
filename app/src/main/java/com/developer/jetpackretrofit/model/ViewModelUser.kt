package com.developer.jetpackretrofit.model

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.jetpackretrofit.`object`.Student
import com.developer.jetpackretrofit.network.MarkApi
import com.google.gson.Gson
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ViewModelUser: ViewModel() {

    private val _data = mutableStateOf("Loading..")

    val data
        get() = _data.value

    init {
        getJsonFromInternet()
    }
    private fun getJsonFromInternet(){
        viewModelScope.launch {
            try {
                _data.value = viewModelScope.async {
                    MarkApi.retrofitService.getPhoto()
                }.await().name
                Log.d("SSS", _data.value)
            }catch (ex: Exception){
                Log.d("ERROR", ex.message.toString())
            }
        }
    }
}