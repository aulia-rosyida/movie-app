package com.dicoding.auliarosyida.livedatawithapi

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 *  class yang berfungsi untuk membuat dan mengkonfigurasi Retrofit
 *
 *  Kelas ini akan membuat kode Anda menjadi lebih efektif
 *  karena Anda tidak perlu membuat konfigurasi Retrofit baru setiap kali membutuhkannya,
 *  namun cukup memanggil fungsi yang ada di dalam class ini saja --> ApiConfig.getApiService()
 *
 *  Anda juga dapat menggunakan class ini untuk keperluan API lain dengan mengganti kode pada base URL dan nama service
 * */
class ApiConfig {

    companion object{
        fun getApiService(): ApiService {
            val loggingInterceptor =
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build()
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://restaurant-api.dicoding.dev/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
            return retrofit.create(ApiService::class.java)
        }
    }

}