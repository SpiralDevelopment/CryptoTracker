package com.spiraldev.cryptoticker.ui.favoruites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.spiraldev.cryptoticker.R
import com.spiraldev.cryptoticker.core.common.BaseFragment
import com.spiraldev.cryptoticker.ui.MainNavigationFragment


class FavoritesFragment : MainNavigationFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun initializeViews() {

    }

    override fun observeViewModel() {

    }
}