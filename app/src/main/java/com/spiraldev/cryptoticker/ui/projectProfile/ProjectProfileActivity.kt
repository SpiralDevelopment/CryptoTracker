package com.spiraldev.cryptoticker.ui.projectProfile

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.spiraldev.cryptoticker.R
import com.spiraldev.cryptoticker.core.common.BaseActivity
import com.spiraldev.cryptoticker.data.local.database.CoinsListEntity
import com.spiraldev.cryptoticker.databinding.ActivityProjectProfileBinding
import com.spiraldev.cryptoticker.util.ChartHelper
import com.spiraldev.cryptoticker.util.Constants
import com.spiraldev.cryptoticker.util.ImageLoader
import com.spiraldev.cryptoticker.util.UIHelper
import com.spiraldev.cryptoticker.util.extensions.doOnChange
import com.spiraldev.cryptoticker.util.extensions.dollarString
import com.spiraldev.cryptoticker.util.extensions.emptyIfNull
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_project_profile.*

@AndroidEntryPoint
class ProjectProfileActivity : BaseActivity() {

    private val viewModel: ProjectProfileViewModel by viewModels()
    private lateinit var binding: ActivityProjectProfileBinding

    private var symbol: String? = null
    private var symbolId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_project_profile)
        binding.apply {
            lifecycleOwner = this@ProjectProfileActivity
            viewModel = this@ProjectProfileActivity.viewModel
        }

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        if (intent?.hasExtra(Constants.EXTRA_SYMBOL) == true) {
            symbol = intent?.getStringExtra(Constants.EXTRA_SYMBOL)
        }

        if (intent?.hasExtra(Constants.EXTRA_SYMBOL_ID) == true) {
            symbolId = intent?.getStringExtra(Constants.EXTRA_SYMBOL_ID)
        }

        supportActionBar?.title = symbol ?: ""
        observeViewModel()

        viewModel.historicalData(symbolId)
    }

    private fun observeViewModel() {
        symbol?.let {
            viewModel.projectBySymbol(it).doOnChange(this) { project ->
                populateViews(project)
            }

            viewModel.historicalData.doOnChange(this) { historicalPriceList ->
                lineChartTitle.text = getString(R.string.line_chart_title).format(30)
                ChartHelper.displayHistoricalLineChart(lineChart, it, historicalPriceList)
            }

            viewModel.dataError.doOnChange(this) { error ->
                if (error) showToast(getString(R.string.historical_data_error))
            }
        }
    }

    private fun populateViews(project: CoinsListEntity) {
        coinItemSymbolTextView.text = project.symbol
        coinItemNameTextView.text = project.name.emptyIfNull()
        coinItemPriceTextView.text = project.price.dollarString()
        UIHelper.showChangePercent(coinItemChangeTextView, project.changePercent)
        ImageLoader.loadImage(coinItemImageView, project.image ?: "")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}