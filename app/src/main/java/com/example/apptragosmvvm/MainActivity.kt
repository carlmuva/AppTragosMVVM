package com.example.apptragosmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.apptragosmvvm.data.model.DataSource
import com.example.apptragosmvvm.databinding.ActivityMainBinding
import com.example.apptragosmvvm.domain.RepoImpl
import com.example.apptragosmvvm.ui.viewmodel.MainViewModel
import com.example.apptragosmvvm.ui.viewmodel.VMFactory

class MainActivity : AppCompatActivity() {

    private lateinit var  mBinding: ActivityMainBinding
    private lateinit var  navController : NavController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        navController= findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this,navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }


}