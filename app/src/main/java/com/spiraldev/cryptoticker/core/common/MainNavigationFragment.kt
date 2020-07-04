package com.spiraldev.cryptoticker.core.common

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.spiraldev.cryptoticker.R


//Interface to update the toolbar with the activity
interface NavigationHost {
    fun registerToolbarWithNavigation(toolbar: Toolbar)
}

/**
 * [MainNavigationFragment] registers the toolbar from the fragment with the activity
 */
abstract class MainNavigationFragment : BaseFragment() {

    private var navigationHost: NavigationHost? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavigationHost) {
            navigationHost = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        navigationHost = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val host = navigationHost ?: return

        val mainToolbar: Toolbar = view.findViewById(R.id.toolbar) ?: return
        mainToolbar.apply {
            host.registerToolbarWithNavigation(this)
        }
    }
}