package com.bichri.yewou.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bichri.yewou.model.HomeModel
import com.bichri.yewou.retrofit.HomeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository {

        private var responseCrowdFunding = MutableLiveData<HomeModel>()


        fun  getCrowdFunding():LiveData<HomeModel>{
            HomeApi().getData().enqueue(object : Callback<HomeModel>{
                override fun onResponse(call: Call<HomeModel>, response: Response<HomeModel>) {
                        if(response.isSuccessful){

                            System.out.println(response.body()!!.content.content)
                        }
                }

                override fun onFailure(call: Call<HomeModel>, t: Throwable) {

                }

            })
                return responseCrowdFunding
        }

}