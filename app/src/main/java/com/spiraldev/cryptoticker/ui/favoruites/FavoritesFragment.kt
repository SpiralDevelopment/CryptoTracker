package com.spiraldev.cryptoticker.ui.favoruites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.spiraldev.cryptoticker.R
import com.spiraldev.cryptoticker.adapters.CoinsListAdapter
import com.spiraldev.cryptoticker.adapters.OnItemClickCallback
import com.spiraldev.cryptoticker.core.common.BaseFragment
import com.spiraldev.cryptoticker.databinding.FragmentFavoritesBinding
import com.spiraldev.cryptoticker.databinding.FragmentListBinding
import com.spiraldev.cryptoticker.ui.MainNavigationFragment
import com.spiraldev.cryptoticker.ui.coinsList.CoinListViewModel
import com.spiraldev.cryptoticker.util.extensions.doOnChange
import kotlinx.android.synthetic.main.fragment_favorites.*
import kotlinx.android.synthetic.main.fragment_list.*


class FavoritesFragment : MainNavigationFragment(), OnItemClickCallback {

    private val viewModel by viewModels<FavoritesViewModel> { viewModelFactory }
    private lateinit var binding: FragmentFavoritesBinding
    private var favouritesAdapter = CoinsListAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
                viewModel = this@FavoritesFragment.viewModel
            }
        observeViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
    }


    override fun initializeViews() {
        favouritesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = favouritesAdapter
        }
    }

    override fun observeViewModel() {
        viewModel.favoriteCoinsList.doOnChange(this) {
            favouritesAdapter.updateList(it)

            if (it.isEmpty()) {
                viewModel.isFavouritesEmpty(true)
            }
        }

        viewModel.toastError.doOnChange(this) {
            showToast(it)
        }

        viewModel.favouriteStock.doOnChange(this) {
            showToast(
                getString(if (it.isFavourite) R.string.added_to_favourite else R.string.removed_to_favourite).format(it.symbol)
            )
        }
    }

    override fun onItemClick(symbol: String) {

    }

    override fun onFavouriteClicked(symbol: String) {
        viewModel.updateFavouriteStatus(symbol)
    }
}