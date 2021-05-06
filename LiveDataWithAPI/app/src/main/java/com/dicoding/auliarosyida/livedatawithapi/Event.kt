package com.dicoding.auliarosyida.livedatawithapi

/**
 * membuat event wrapper
 *
 * T adalah tipe generic yang bisa digunakan supaya kelas ini dapat membungkus berbagai macam data.
 * Data yang dibungkus tersebut kemudian akan dimasukkan ke dalam variabel content.
 *
 * Untuk menggunakan kelas ini cukup mudah.
 * Sesuai namanya, Anda hanya perlu membungkus (wrap) data yang ingin dijadikan single event.
 * Anda dapat melihatnya pada kelas MainViewModel
 * */
open class Event<out T>(private val content: T) {

    @Suppress("MemberVisibilityCanBePrivate")
    var hasBeenHandled = false //Awalnya variabel hasBeenHandled bernilai false.
        private set

    /**
     *  fungsi utama dari kelas ini yaitu terdapat pada fungsi getContentIfNotHandled()
     *  Fungsi tersebut akan memeriksa apakah aksi ini pernah dieksekusi sebelumnya.
     *  Caranya yaitu dengan memanipulasi variabel hasBeenHandled.
     * */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) { // pada aksi selanjutnya ia akan mengembalikan null karena hasBeenHandled telah bernilai true
            null
        } else { //ketika aksi pertama kali dilakukan nilai hasBeenHandled akan diubah menjadi true
            hasBeenHandled = true
            content
        }
    }

    //fungsi peekContent yang bisa Anda gunakan untuk melihat nilai dari content walaupun aksi event sudah dilakukan
    fun peekContent(): T = content
}