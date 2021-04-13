package com.bichri.yewou.retrofit

import com.bichri.yewou.model.HomeModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface HomeApi {

    @GET("/yewou-api/v1/crowd-funding-projects/")
    fun getData():Call<HomeModel>


    companion object {
        operator fun invoke(): HomeApi {
            return Retrofit.Builder()
                .baseUrl("https://app-d03140c7-2b3d-41aa-b955-e1763bf0478c.cleverapps.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(HomeApi::class.java)
        }
    }
}