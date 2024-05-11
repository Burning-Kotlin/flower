package com.bulko.flowerkkio

import android.media.Image
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private lateinit var interest1: ImageButton
    private lateinit var interest2: ImageButton
    private lateinit var interest3: ImageButton
    private lateinit var interest4: ImageButton

    private lateinit var homeBtn: ImageButton
    private lateinit var subscribeBtn: ImageButton
    private lateinit var profileBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        interest1 = findViewById(R.id.interest1)
        interest2 = findViewById(R.id.interest2)
        interest3 = findViewById(R.id.interest3)
        interest4 = findViewById(R.id.interest4)

        homeBtn = findViewById(R.id.homeBtn)
        subscribeBtn = findViewById(R.id.subscribeBtn)
        profileBtn = findViewById(R.id.profileBtn)

        interest1.setOnClickListener {
            // ImageButton 클릭되었을 때
        }

        interest2.setOnClickListener {
            // ImageButton 클릭되었을 때
        }

        interest3.setOnClickListener {
            // ImageButton 클릭되었을 때
        }

        interest4.setOnClickListener {
            // ImageButton 클릭되었을 때
        }

        // 처음 앱 실행 시 HomeFragment 로드
        loadFragment(HomeFragment())

        // Home 버튼 클릭 시 HomeFragment 로드
        homeBtn.setOnClickListener {
            loadFragment(HomeFragment())
        }

        // Subscribe 버튼 클릭 시 SubscribeFragment 로드
        subscribeBtn.setOnClickListener {
            loadFragment(SubscribeFragment())
        }

        // Profile 버튼 클릭 시 ProfileFragment 로드
        profileBtn.setOnClickListener {
            loadFragment(ProfileFragment())
        }

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_view, fragment)
            .commit()
    }



}