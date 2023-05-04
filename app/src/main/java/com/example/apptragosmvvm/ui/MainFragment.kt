package com.example.apptragosmvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apptragosmvvm.AppDatabase
import com.example.apptragosmvvm.R
import com.example.apptragosmvvm.data.model.DataSource
import com.example.apptragosmvvm.data.model.Drink
import com.example.apptragosmvvm.databinding.FragmentMainBinding
import com.example.apptragosmvvm.domain.RepoImpl
import com.example.apptragosmvvm.ui.viewmodel.MainViewModel
import com.example.apptragosmvvm.ui.viewmodel.VMFactory
import com.example.apptragosmvvm.vo.Resource


class MainFragment : Fragment(), MainAdapter.OnTragoClickListener {

    private lateinit var mBinding: FragmentMainBinding

    private val viewModel by activityViewModels<MainViewModel> { VMFactory(RepoImpl(DataSource(
        AppDatabase.getDatabase(requireActivity().applicationContext)
    ))) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMainBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setuprecyclerView()
        setupSearchView()
        setupObservers()
        mBinding.btnIrFavoritos.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_favoritosFragment)
        }

    }

    private fun setupObservers(){
        viewModel.fetchTragosList.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    mBinding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    mBinding.progressBar.visibility = View.GONE
                    mBinding.rvTragos.adapter = MainAdapter(requireContext(), result.data,this)
                }
                is Resource.Failure -> {
                    mBinding.progressBar.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        "Ocurrió un error al traer los datos ${result.exception}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    private fun setuprecyclerView() {
        mBinding.rvTragos.layoutManager =
            LinearLayoutManager(requireContext()) // para que se visualice el rv
        mBinding.rvTragos.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        ) // para agregarle al rv unas lineas verticales

    }

    override fun onTragoClick(drink: Drink) {
        val bundle = Bundle()
        bundle.putParcelable("drink",drink)
        findNavController().navigate(R.id.action_mainFragment_to_tragosDetalleFragment,bundle)
    }

    private fun setupSearchView(){
        mBinding.searchView.setOnQueryTextListener(object:androidx.appcompat.widget.SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.setTrago(query!!)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {return false}
        })
    }
}