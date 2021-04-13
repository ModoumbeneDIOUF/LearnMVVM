package com.bichri.yewou.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProviders
import com.bichri.yewou.R
import com.bichri.yewou.adapter.HomeAdapter
import com.bichri.yewou.model.HomeModel
import com.bichri.yewou.network.Network
import com.bichri.yewou.viewModel.HomeViewModel

class Home : AppCompatActivity() {

lateinit var homeViewModel: HomeViewModel
lateinit var homeAdapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val context = this

        // recyclerView from layout and assigning layoutManager
        val recView = findViewById<RecyclerView>(R.id.recyclerView)
        recView.layoutManager = LinearLayoutManager(this)

        // getting view model class from ViewModelProviders

        if(Network.checkNetwork(this)){
            homeViewModel = ViewModelProviders.of(this, object : ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return HomeViewModel() as T
                }
            } ).get(HomeViewModel::class.java)
                val observer = Observer<HomeModel>{
                    recView.adapter = homeAdapter
                    homeAdapter.notifyDataSetChanged()
                }

                homeViewModel.getCrowdFunding().observe(this, observer)
        } else Toast.makeText(this, "Check network connection", Toast.LENGTH_SHORT).show()

    }


}