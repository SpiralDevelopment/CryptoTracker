package com.spiraldev.cryptoticker.ui.home.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.spiraldev.cryptoticker.databinding.FragmentSettingsBinding
import com.spiraldev.cryptoticker.core.common.MainNavigationFragment
import com.spiraldev.cryptoticker.util.ThemeHelper
import com.spiraldev.cryptoticker.util.ThemeMode
import com.spiraldev.cryptoticker.util.extensions.doOnChange
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SettingsFragment : MainNavigationFragment() {

    private val viewModel: SettingsViewModel by viewModels()
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
                viewModel = this@SettingsFragment.viewModel
            }
        observeViewModel()
        return binding.root
    }

    override fun initializeViews() {

    }

    override fun observeViewModel() {
        viewModel.isDarkMode.doOnChange(this) {
            Timber.d("On Theme changed")
            ThemeHelper.applyTheme(if (it) ThemeMode.Dark else ThemeMode.Light)
        }
    }
}