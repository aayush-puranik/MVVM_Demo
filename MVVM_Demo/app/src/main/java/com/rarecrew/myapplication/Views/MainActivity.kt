package com.rarecrew.myapplication.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rarecrew.myapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, RecipeListFragment()).commit()
    }
}