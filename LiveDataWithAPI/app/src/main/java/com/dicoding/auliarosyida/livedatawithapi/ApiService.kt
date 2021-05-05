package com.dicoding.auliarosyida.livedatawithapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * untuk persiapan Retrofit
 * */
interface ApiService {

    @GET("detail/{id}")
    fun getRestaurant(
            @Path("id") id: String
    ): Call<RestaurantResponse>

}