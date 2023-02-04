package com.example.ejemplo

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejemplo.model.Perros
import com.example.ejemplo.repository.PerrosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val repository: PerrosRepository
) : ViewModel() {
    private val _perros = MutableLiveData<List<Perros>>()

    fun getNews(): LiveData<List<Perros>> {
        viewModelScope.launch(Dispatchers.IO) {
            val perros = repository.getPerros()

            _perros.postValue(perros)

        }
        return _perros
    }
}