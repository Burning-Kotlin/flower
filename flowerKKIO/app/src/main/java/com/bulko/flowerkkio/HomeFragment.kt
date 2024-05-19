package com.bulko.flowerkkio

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    private lateinit var interest1: ImageButton
    private lateinit var interest2: ImageButton
    private lateinit var interest3: ImageButton
    private lateinit var interest4: ImageButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.new_layout, container, false)
    }
}