package com.example.afinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.afinal.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //setContentView(R.layout.activity_main)
        binding =DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        drawerLayout = binding.drawerLayout
        val navController = this.findNavController(R.id.titleFragment)
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)
       // NavigationUI.setupWithNavController(binding.navView, navController)
       NavigationUI.setupWithNavController(binding.navView,navController)


    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.titleFragment)
        return NavigationUI.navigateUp(navController,drawerLayout)

    }


    }

