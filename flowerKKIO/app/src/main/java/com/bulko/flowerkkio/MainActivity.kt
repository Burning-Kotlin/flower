package com.bulko.flowerkkio

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.security.MessageDigest

class MainActivity : AppCompatActivity() {

    private lateinit var homeBtn: ImageButton
    private lateinit var subscribeBtn: ImageButton
    private lateinit var profileBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // 액티비티 메인 실행시켰을 때 홈화면 실행
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_view, HomeFragment())
            .commit()

        homeBtn = findViewById(R.id.homeBtn)
        subscribeBtn = findViewById(R.id.subscribeBtn)
        profileBtn = findViewById(R.id.profileBtn)

        homeBtn.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_view, HomeFragment())
                .commit()
        }
        subscribeBtn.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_view, SubRecFragment())
                .commit()
        }
        profileBtn.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_view, ProfileFragment())
                .commit()
        }
    }
}