package com.example.apptragosmvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.apptragosmvvm.R
import com.example.apptragosmvvm.data.model.Drink
import com.example.apptragosmvvm.databinding.FragmentMainBinding
import com.example.apptragosmvvm.databinding.FragmentTragosDetalleBinding


class TragosDetalleFragment : Fragment() {

    private lateinit var drink: Drink
    private lateinit var mBinding: FragmentTragosDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            drink = it.getParcelable<Drink>("drink")!!
            //Log.d("DETALLES_FRAG", "${drink.toString()}")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentTragosDetalleBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(drink.imagen).centerCrop().into(mBinding.imgTrago)
        mBinding.tragoTitle.text = drink.nombre
        mBinding.tragoDesc.text = drink.descripcion
        if(drink.hasAlcohol == "Non_Alcoholic"){
            mBinding.txtHasAlcohol.text = "Bebida sin alcohol"
        }else{
            mBinding.txtHasAlcohol.text = "Bebida con alcohol"
        }


    }


}