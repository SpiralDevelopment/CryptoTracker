package com.spiraldev.cryptoticker.ui.coinsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.spiraldev.cryptoticker.api.models.Coin
import com.spiraldev.cryptoticker.api.succeeded
import com.spiraldev.cryptoticker.core.common.BaseViewModel
import com.spiraldev.cryptoticker.data.repository.coinsList.CoinsListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import com.spiraldev.cryptoticker.api.Result

class CoinListViewModel @Inject constructor(private val coinsListRepository: CoinsListRepository) :
    BaseViewModel() {

    val coinsListData = MutableLiveData<List<Coin>>()

    fun loadCoinsList(targetCur: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            val result = coinsListRepository.coinsList(targetCur)
            _isLoading.postValue(false)

            when (result) {
                is Result.Success -> {
                    if (result.succeeded) {
                        coinsListData.postValue(result.data)
                    } else {
                        Timber.d("Error")
                    }
                }
                is Result.Error -> Timber.d("Error")
            }
        }
    }

}