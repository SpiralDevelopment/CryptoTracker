package com.spiraldev.cryptoticker.ui.coinsList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.spiraldev.cryptoticker.R
import com.spiraldev.cryptoticker.core.common.BaseFragment
import com.spiraldev.cryptoticker.databinding.FragmentListBinding
import com.spiraldev.cryptoticker.databinding.FragmentSettingsBinding
import com.spiraldev.cryptoticker.ui.MainNavigationFragment
import com.spiraldev.cryptoticker.ui.settings.SettingsViewModel
import com.spiraldev.cryptoticker.util.extensions.doOnChange


class CoinListFragment : MainNavigationFragment() {

    private val viewModel by viewModels<CoinListViewModel> { viewModelFactory }
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
                viewModel = this@CoinListFragment.viewModel
            }
        observeViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        viewModel.loadCoinsList("usd")
    }

    override fun initializeViews() {

    }

    override fun observeViewModel() {
        viewModel.coinsListData.doOnChange(this){
            showToast("Success")
        }
    }
}