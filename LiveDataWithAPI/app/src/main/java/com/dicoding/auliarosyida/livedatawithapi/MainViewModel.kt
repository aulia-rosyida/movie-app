package com.dicoding.auliarosyida.livedatawithapi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    /**
     * variabel untuk menampung data restoran dan review
     * MutableLiveData bisa kita ubah value-nya, sedangkan LiveData bersifat read-only (tidak dapat diubah).
     *
     * Enkapsulasi LiveData dengan Backing Property:
     * membuat data yang bertipe MutableLiveData menjadi private (_listReview) dan yang bertipe LiveData menjadi public (listReview)
     *
     * Dengan begitu Anda dapat mencegah variabel yang bertipe MutableLiveData diubah dari luar class.
     * Karena memang seharusnya hanya ViewModel-lah yang dapat mengubah data.
     * */
    private val _restaurant = MutableLiveData<Restaurant>()
    val restaurant: LiveData<Restaurant> = _restaurant
    private val _listReview = MutableLiveData<List<CustomerReviewsItem>>()
    val listReview: LiveData<List<CustomerReviewsItem>> = _listReview
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    // variabel untuk menyimpan text yang akan ditampilkan Snackbar
    private val _snackbarText = MutableLiveData<Event<String>>() // gunakan wrapper Event.kt untuk membungkus variabel String
    val snackbarText: LiveData<Event<String>> = _snackbarText

    companion object{
        private const val TAG = "MainViewModel"
        private const val RESTAURANT_ID = "uewq1zg2zlskfw1e867"
    }

    /**
     * fungsi untuk mendapatkan data dari API serta memasukkan hasil responnya ke dalam variabel LiveData
     * */

    init {
        findRestaurant()
    }
    fun findRestaurant() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getRestaurant(RESTAURANT_ID)
        client.enqueue(object : Callback<RestaurantResponse> {
            override fun onResponse(
                    call: Call<RestaurantResponse>,
                    response: Response<RestaurantResponse>
            ) {
                _isLoading.value = false //Yang dimaksud mengubah value-nya adalah pada bagian ini
                if (response.isSuccessful) {
                    _restaurant.value = response.body()?.restaurant
                    _listReview.value = response.body()?.restaurant?.customerReviews
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<RestaurantResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    /**
     * fungsi untuk mengirim review pada MainViewModel
     * */
    fun postReview(review: String) {
        _isLoading.value = true
        val client = ApiConfig.getApiService().postReview(RESTAURANT_ID, "Dicoding", review)

        client.enqueue(object : Callback<PostReviewResponse> {
            override fun onResponse(call: Call<PostReviewResponse>, response: Response<PostReviewResponse>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _listReview.value = response.body()?.customerReviews
                    _snackbarText.value =  Event(response.body()?.message.toString())// isi variabel tersebut dengan pesan yang didapat setelah sukses mengirim review
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<PostReviewResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}