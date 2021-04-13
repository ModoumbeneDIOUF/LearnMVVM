package com.bichri.yewou.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bichri.yewou.model.HomeModel
import com.bichri.yewou.repository.HomeRepository

class HomeViewModel: ViewModel() {
    private var homeRepositoty: HomeRepository = HomeRepository()
    private lateinit var crowFunding:LiveData<HomeModel>

    fun getCrowdFunding():LiveData<HomeModel>{
        return crowFunding
    }

    init {
        homeRepositoty = HomeRepository()
        crowFunding = homeRepositoty.getCrowdFunding()
    }

}