package com.example.binarchapter7.main

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.binarchapter7.R
import com.example.binarchapter7.pojo.PostLoginResponse
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    companion object {
        var username: String = ""
        var email: String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        setSupportActionBar(menu_actionbar)

        val user = intent.getParcelableExtra<PostLoginResponse.Data>("data")
        username = user?.username.toString()
        email = user?.email.toString()

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

//        val bundle = Bundle()
//        bundle.putString("username", username)
//        bundle.putString("email", email)
//        navController.setGraph(navController.graph, bundle)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_battle, R.id.navigation_history, R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

}