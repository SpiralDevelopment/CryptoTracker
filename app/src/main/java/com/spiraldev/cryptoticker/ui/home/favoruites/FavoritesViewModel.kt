package com.spiraldev.cryptoticker.ui.home.favoruites

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.spiraldev.cryptoticker.core.common.BaseViewModel
import com.spiraldev.cryptoticker.data.local.database.CoinsListEntity
import com.spiraldev.cryptoticker.data.repository.favorites.FavoritesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.spiraldev.cryptoticker.api.Result

class FavoritesViewModel @ViewModelInject constructor(private val repository: FavoritesRepository) :
    BaseViewModel() {

    val favoriteCoinsList: LiveData<List<CoinsListEntity>> = repository.favoriteCoins

    private val _favouriteStock = MutableLiveData<CoinsListEntity>()
    val favouriteStock: LiveData<CoinsListEntity> = _favouriteStock

    private val _favouritesEmpty = MutableLiveData<Boolean>()
    val favouritesEmpty: LiveData<Boolean> = _favouritesEmpty

    fun updateFavouriteStatus(symbol: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.updateFavouriteStatus(symbol)
            when (result) {
                is Result.Success -> _favouriteStock.postValue(result.data)
                is Result.Error -> _toastError.postValue(result.message)
            }
        }
    }

    fun isFavouritesEmpty(empty: Boolean) {
        _favouritesEmpty.postValue(empty)
    }
}