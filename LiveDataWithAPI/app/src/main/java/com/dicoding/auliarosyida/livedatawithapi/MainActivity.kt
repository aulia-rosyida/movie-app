package com.dicoding.auliarosyida.livedatawithapi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.dicoding.auliarosyida.livedatawithapi.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        supportActionBar?.hide()

        /**
         * observe pada variabel snackbarText yang ada di dalam MainActivity dan tampilkan menggunakan Snackbar
         * sampai sini, snackbar sudah muncul, tp pada saat di rotate dia akan muncul lagi
         * karena observe mendeteksi adanya message saat konfigurasi changes --> butuh Event Wrapper
         * */
        mainViewModel.snackbarText.observe(this, {
            // memanfaatkan fungsi getContentIfHandled dari kelas Event untuk mengetahui apakah aksi tersebut pernah dilakukan sebelumnya atau tidak
            it.getContentIfNotHandled()?.let { snackBarText -> //untuk mengambil data tersebut, cukup panggil fungsi getContentIfNotHandled
                Snackbar.make(
                        window.decorView.rootView,
                        snackBarText,
                        Snackbar.LENGTH_SHORT
                ).show()
            } //Secara otomatis ketika aksi sudah pernah dilakukan sebelumnya, maka ia akan menghasilkan null
        })

        //mengambil data dari API dengan menggunakan retrofit dan LiveData
        /**
         *  cara mendapatkan value dari LiveData yang ada pada kelas ViewModel. Perhatikan metode observe
         *  observe LiveData di ViewModel dari MainActivity dan tampilkan hasilnya pada komponen UI
         *
         *  proses ini dilakukan secara asynchronous sehingga tidak akan mengganggu interaksi UI Anda
         * */
        mainViewModel.restaurant.observe(this, { restaurant ->
            activityMainBinding.tvTitle.text = restaurant.name
            activityMainBinding.tvDescription.text = restaurant.description
            Glide.with(this)
                    .load("https://restaurant-api.dicoding.dev/images/large/${restaurant.pictureId}")
                    .into(activityMainBinding.ivPicture)
        })

        mainViewModel.listReview.observe(this, { consumerReviews -> // custom variabel untuk hasil LiveData yang ada di ViewModel.
                                                       // Jika Anda tidak menuliskan customerReviews-> maka variabel default-nya adalah it.
                                                        // selalu diperbarui secara realtime sesuai dengan perubahan yang ada di kelas ViewModel
            val listReview = consumerReviews.map {
                "${it.review}\n- ${it.name}"
            }
            activityMainBinding.lvReview.adapter =
                    ArrayAdapter(this, R.layout.item_review, listReview)
            activityMainBinding.edReview.setText("")
        })

        mainViewModel.isLoading.observe(this, {
            activityMainBinding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })

        //beri aksi ketika tombol kirim review diklik
        activityMainBinding.btnSend.setOnClickListener { view ->
            mainViewModel.postReview(activityMainBinding.edReview.text.toString())
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}