package com.example.newsify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsify.Fragments.HomeScreenFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, HomeScreenFragment()).commit()
    }
}