package com.appstreet.fitness.ui.home.adapter

import com.appstreet.base.cell.Cell
import com.appstreet.fitness.ui.home.adapter.delegate.ElementDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class Adapter(private val modelList: MutableList<Cell>) :  ListDelegationAdapter<List<Cell>>() {
//    interface CellListener {
//        fun onCellActivityClick(response: ModelResponse)
//
//    }
    init {
        delegatesManager
            .addDelegate(ElementDelegate())

        setItems(modelList)
    }}