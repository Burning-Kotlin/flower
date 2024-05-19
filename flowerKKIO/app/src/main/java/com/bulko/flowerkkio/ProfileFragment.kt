package com.bulko.flowerkkio

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class ProfileFragment : Fragment(), View.OnClickListener {

    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 2. Context를 액티비티로 형변환해서 할당
        mainActivity = context as MainActivity
    }

    // 버튼 선언
    private lateinit var backBtn: ImageButton
    private lateinit var editProfileBtn: Button
    private lateinit var myPostBtn: Button
    private lateinit var scrapBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.my_page, container, false)

        backBtn = v.findViewById(R.id.backBtn)
        editProfileBtn = v.findViewById(R.id.editProfileBtn)
        myPostBtn = v.findViewById(R.id.myPostBtn)
        scrapBtn = v.findViewById(R.id.scrapBtn)

        childFragmentManager.beginTransaction() // 내 프로필 누르면 일단 내가 올린 글 프래그먼트 뜨게
            .replace(R.id.sub, PostFragment())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        backBtn.setOnClickListener {
            Toast.makeText(mainActivity, "백버튼 눌림", Toast.LENGTH_SHORT).show()
        }
        editProfileBtn.setOnClickListener {
            startActivity(Intent(getActivity(), EditProfileActivity::class.java))
        }
        myPostBtn.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.sub, PostFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }
        scrapBtn.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.sub, ScrapFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }
        return v
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}