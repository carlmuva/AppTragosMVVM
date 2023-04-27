package com.example.apptragosmvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.apptragosmvvm.R
import com.example.apptragosmvvm.data.model.DataSource
import com.example.apptragosmvvm.databinding.FragmentMainBinding
import com.example.apptragosmvvm.domain.RepoImpl
import com.example.apptragosmvvm.ui.viewmodel.MainViewModel
import com.example.apptragosmvvm.ui.viewmodel.VMFactory


class MainFragment : Fragment() {

    private lateinit var mBinding: FragmentMainBinding
    private val viewModel by viewModels<MainViewModel> { VMFactory(RepoImpl(DataSource())) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMainBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.btnIrDetalles.setOnClickListener {
            findNavController().navigate(R.id.tragosDetalleFragment)
        }

    }

}