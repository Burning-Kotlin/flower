package com.bulko.flowerkkio

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment

class ScrapFragment : Fragment() {
    lateinit var mainActivity: MainActivity
    lateinit var myScrap1: ImageView
    lateinit var myScrap2: ImageView


    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 2. Context를 액티비티로 형변환해서 할당
        mainActivity = context as MainActivity
    }

    private lateinit var postBtn: Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.scrap_layout, container, false)
        myScrap1 = v.findViewById(R.id.myScrap1)
        myScrap2 = v.findViewById(R.id.myScrap2)

        myScrap1.setOnClickListener {
            Toast.makeText(mainActivity, "스크랩 1 선택", Toast.LENGTH_SHORT).show()
        }
        myScrap2.setOnClickListener {
            Toast.makeText(mainActivity, "스크랩 2 선택", Toast.LENGTH_SHORT).show()
        }

        return v
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//
//        postBtn.setOnClickListener {
//            (parentFragment as ProfileFragment).scrap()
//        }
    }
}