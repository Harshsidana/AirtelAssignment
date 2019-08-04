package com.appstreet.fitness.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appstreet.base.cell.Cell
import com.appstreet.base.extension.showLongToast
import com.appstreet.base.model.DataState
import com.appstreet.fitness.R
import com.appstreet.fitness.ui.home.adapter.Adapter
import com.appstreet.home.cell.HomeCell
import com.appstreet.home.model.response.ApiReponse
import com.appstreet.home.view.AbstractHomeActivity
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AbstractHomeActivity(), Adapter.CellListener {


    override fun getLayoutRes(): Int {
        return R.layout.activity_home
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getCardCellDetails().observe(this, Observer<DataState<List<ApiReponse>>> {
            when (it) {
                is DataState.Success -> {
                    val list: MutableList<Cell> = ArrayList()
                    for (i in 0 until it.data.size) {
                        list.add(HomeCell(it.data[i]))
                    }

                    val rvAdapter = Adapter(list,this)
                    recyclerView.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
                    recyclerView.adapter = rvAdapter


                }
                is DataState.Failure -> {
                    showLongToast("Some Error fetching details")
                }
            }

        })



    }

    override fun onCellActivityClick(response: ApiReponse) {
        val intent = Intent(applicationContext, UserDetails::class.java)
        val bundle = Bundle()
        bundle.putString("Username",response.username)
        bundle.putString("Name",response.name)
        bundle.putString("Url",response.url)
        bundle.putString("Avatar",response.avatar)
        bundle.putString("Repo Description",response.repo.description)
        bundle.putString("Repo Name",response.repo.name)
        bundle.putString("Repo Url",response.repo.url)
        intent.putExtra("Bundle", bundle)
        startActivity(intent)


    }
}
