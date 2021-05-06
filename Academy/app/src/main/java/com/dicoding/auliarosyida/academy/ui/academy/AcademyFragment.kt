package com.dicoding.auliarosyida.academy.ui.academy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.auliarosyida.academy.databinding.FragmentAcademyBinding
import com.dicoding.auliarosyida.academy.viewmodel.ViewModelFactory

/**
 * AcademyFragment: Digunakan untuk menampilkan semua Course.
 * */
class AcademyFragment : Fragment() {

    private lateinit var fragmentAcademyBinding: FragmentAcademyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentAcademyBinding = FragmentAcademyBinding.inflate(layoutInflater, container, false)
        return fragmentAcademyBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            //Ketika Activity atau Fragment membutuhkan ViewModel, maka akan memanggil kelas Factory untuk membuat ViewModel.
            val factory = ViewModelFactory.getInstance(requireActivity()) // inisialisasi ViewModelFactory

            // ganti default factory dengan factory yang sudah Anda buat
            val viewModel = ViewModelProvider(this, factory)[AcademyViewModel::class.java]

            val academyAdapter = AcademyAdapter()

            // kode untuk melakukan observe untuk membaca LiveData
            fragmentAcademyBinding.progressBar.visibility = View.VISIBLE
            viewModel.getCourses().observe(requireActivity(), { courses ->
                fragmentAcademyBinding.progressBar.visibility = View.GONE
                academyAdapter.setCourses(courses)
                academyAdapter.notifyDataSetChanged()
            })

            with(fragmentAcademyBinding.rvAcademy) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = academyAdapter
            }
        }
    }
}