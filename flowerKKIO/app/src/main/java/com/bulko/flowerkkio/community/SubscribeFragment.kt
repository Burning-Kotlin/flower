package com.bulko.flowerkkio.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bulko.flowerkkio.R

class SubscribeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_subscribe, container, false)
        val subscribeText = view.findViewById<TextView>(R.id.subscribe_text)
        subscribeText.text = "꽃 구독창"
        return view
    }



}