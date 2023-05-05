package com.example.apptragosmvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apptragosmvvm.AppDatabase
import com.example.apptragosmvvm.R
import com.example.apptragosmvvm.data.model.DataSource
import com.example.apptragosmvvm.data.model.Drink
import com.example.apptragosmvvm.databinding.FragmentFavoritosBinding
import com.example.apptragosmvvm.databinding.FragmentMainBinding
import com.example.apptragosmvvm.domain.RepoImpl
import com.example.apptragosmvvm.ui.viewmodel.MainViewModel
import com.example.apptragosmvvm.ui.viewmodel.VMFactory
import com.example.apptragosmvvm.vo.Resource


class FavoritosFragment : Fragment(),MainAdapter.OnTragoClickListener {

    private lateinit var mBinding: FragmentFavoritosBinding

    private val viewModel by activityViewModels<MainViewModel> { VMFactory(
        RepoImpl(
            DataSource(
        AppDatabase.getDatabase(requireActivity().applicationContext))
        )
    ) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFavoritosBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setuprecyclerView()
        setupObservers()

    }

    private fun setupObservers(){
        viewModel.getTragosFavoritos().observe(viewLifecycleOwner, Observer { result->
            when(result){
                is Resource.Loading -> {}
                is Resource.Success -> {
                    Log.d("Favoritos", "${result.data}")
                    val lista: List<Drink> = result.data.map { 
                        Drink(it.tragoId,it.imagen,it.nombre,it.descripcion, it.hasAlcohol)
                    }
                    mBinding.rvTragosFavoritos.adapter = MainAdapter(requireContext(),lista,this)
                }
                is Resource.Failure -> {

                }
            }
        })
    }

    private fun setuprecyclerView() {
        mBinding.rvTragosFavoritos.layoutManager =
            LinearLayoutManager(requireContext()) // para que se visualice el rv
        mBinding.rvTragosFavoritos.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        ) // para agregarle al rv unas lineas verticales

    }

    override fun onTragoClick(drink: Drink) {
        TODO("Not yet implemented")
    }
}