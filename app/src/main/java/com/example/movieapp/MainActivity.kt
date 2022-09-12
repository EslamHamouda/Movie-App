package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.replace
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.home.ui.HomeFragment
import com.example.movieapp.search.ui.SearchFragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHomeFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController=navHomeFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)

    }
}