package com.dicoding.auliarosyida.academy.ui.reader.list

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.auliarosyida.academy.data.ModuleEntity
import com.dicoding.auliarosyida.academy.databinding.FragmentModuleListBinding
import com.dicoding.auliarosyida.academy.ui.reader.CourseReaderActivity
import com.dicoding.auliarosyida.academy.ui.reader.CourseReaderCallback
import com.dicoding.auliarosyida.academy.ui.reader.CourseReaderViewModel
import com.dicoding.auliarosyida.academy.utils.DataDummy
import com.dicoding.auliarosyida.academy.viewmodel.ViewModelFactory

/**
 * ModuleListFragment: Digunakan untuk menampilkan semua Module sesuai Course yang dipilih.
 * */
class ModuleListFragment : Fragment() , MyAdapterClickListener {

    companion object {
        val TAG: String = ModuleListFragment::class.java.simpleName

        fun newInstance(): ModuleListFragment = ModuleListFragment()
    }

    private lateinit var fragmentModuleListBinding: FragmentModuleListBinding
    private lateinit var adapter: ModuleListAdapter
    private lateinit var courseReaderCallback: CourseReaderCallback
    private lateinit var viewModel: CourseReaderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentModuleListBinding = FragmentModuleListBinding.inflate(inflater, container, false)
        return fragmentModuleListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(requireActivity(), factory)[CourseReaderViewModel::class.java]
        adapter = ModuleListAdapter(this)

        fragmentModuleListBinding.progressBar.visibility = View.VISIBLE
        viewModel.getModules().observe(requireActivity(), { modules ->
            fragmentModuleListBinding.progressBar.visibility = View.GONE
            populateRecyclerView(modules)
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        courseReaderCallback = context as CourseReaderActivity
    }

    override fun onItemClicked(position: Int, moduleId: String) {
        courseReaderCallback.moveTo(position, moduleId)
        viewModel.setSelectedModule(moduleId)
    }

    private fun populateRecyclerView(modules: List<ModuleEntity>) {
        with(fragmentModuleListBinding) {
            progressBar.visibility = View.GONE
            adapter.setModules(modules)
            rvModule.layoutManager = LinearLayoutManager(context)
            rvModule.setHasFixedSize(true)
            rvModule.adapter = adapter
            val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            rvModule.addItemDecoration(dividerItemDecoration)
        }
    }
}