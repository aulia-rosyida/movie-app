package com.dicoding.auliarosyida.livedatawithapi

import com.google.gson.annotations.SerializedName

/**
 * Dengan menggunakan RoboPojoGenerator, Anda telah membuat class model yang berfungsi untuk menampung data dari JSON.
 * 3 class yang dibuat merepresentasikan kedalaman object yang diambil.
 *
 * Untuk membedakan antara JSONObject dan JSONArray, Anda cukup menggunakan List<CustomerReviewsItem> untuk JSONArray;
 * dan Restaurant tanpa List untuk JSONObject.
 * untuk menandai sebuah variabel terhubung dengan data JSON, Anda gunakan annotation @SerializedName
 * */

//Class RestaurantResponse untuk mengambil data respon dari server seperti eror dan message.
data class RestaurantResponse(

	@field:SerializedName("restaurant")
	val restaurant: Restaurant,

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String
)

//class CustomerReviewItem untuk mengambil JSON Array customerReviews
data class CustomerReviewsItem(

	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("review")
	val review: String,

	@field:SerializedName("name")
	val name: String
)

//class Restaurant untuk mengambil JSON Object restaurant
data class Restaurant(

	@field:SerializedName("customerReviews")
	val customerReviews: List<CustomerReviewsItem>,

	@field:SerializedName("pictureId")
	val pictureId: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("rating")
	val rating: Double,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("id")
	val id: String
)

// model untuk menerima respon ketika mengirim data seperti yang kita lihat pada postman
data class PostReviewResponse(

		@field:SerializedName("customerReviews")
		val customerReviews: List<CustomerReviewsItem>,

		@field:SerializedName("error")
		val error: Boolean,

		@field:SerializedName("message")
		val message: String
)
