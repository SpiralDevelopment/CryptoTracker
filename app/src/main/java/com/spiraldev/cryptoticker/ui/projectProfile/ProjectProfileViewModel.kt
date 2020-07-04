package com.spiraldev.cryptoticker.ui.projectProfile

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.spiraldev.cryptoticker.core.common.BaseViewModel
import com.spiraldev.cryptoticker.data.repository.projectProfile.ProjectProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.spiraldev.cryptoticker.api.Result

class ProjectProfileViewModel @ViewModelInject constructor(private val repository: ProjectProfileRepository) :
    BaseViewModel() {

    fun projectBySymbol(symbol: String) = repository.projectBySymbol(symbol)

    private val _dataError = MutableLiveData<Boolean>()
    val dataError: LiveData<Boolean> = _dataError

    private val _historicalData = MutableLiveData<List<DoubleArray>>()
    val historicalData: LiveData<List<DoubleArray>> = _historicalData

    fun historicalData(symbol: String?) {
        symbol?.let {
            viewModelScope.launch(Dispatchers.IO) {
                _isLoading.postValue(true)
                val result = repository.historicalPrice(it)
                _isLoading.postValue(false)

                when (result) {
                    is Result.Success -> {
                        _historicalData.postValue(result.data.prices)
                        _dataError.postValue(false)
                    }
                    is Result.Error -> _dataError.postValue(true)
                }
            }
        }
    }

}