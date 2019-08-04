package com.appstreet.fitness.ui.home

import android.os.Bundle
import androidx.lifecycle.Observer
import com.appstreet.base.model.DataState
import com.appstreet.fitness.R
import com.appstreet.home.model.response.ApiReponse
import com.appstreet.home.view.AbstractHomeActivity


class HomeActivity : AbstractHomeActivity() {

    override fun getLayoutRes(): Int {
        return R.layout.activity_home
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getCardCellDetails().observe(this, Observer<DataState<List<ApiReponse>>> {
            when (it) {
                is DataState.Success -> {
                }
                is DataState.Failure -> {

                }
            }

        })


    }
}
