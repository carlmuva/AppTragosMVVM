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
import com.example.apptragosmvvm.AppDatabase
import com.example.apptragosmvvm.R
import com.example.apptragosmvvm.data.model.DataSource
import com.example.apptragosmvvm.databinding.FragmentFavoritosBinding
import com.example.apptragosmvvm.databinding.FragmentMainBinding
import com.example.apptragosmvvm.domain.RepoImpl
import com.example.apptragosmvvm.ui.viewmodel.MainViewModel
import com.example.apptragosmvvm.ui.viewmodel.VMFactory
import com.example.apptragosmvvm.vo.Resource


class FavoritosFragment : Fragment() {

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

        viewModel.getTragosFavoritos().observe(viewLifecycleOwner, Observer { result->
            when(result){
                is Resource.Loading -> {}
                is Resource.Success -> {
                    Log.d("Favoritos", "${result.data}")
                }
                is Resource.Failure -> {

                }
            }
        })
    }


}