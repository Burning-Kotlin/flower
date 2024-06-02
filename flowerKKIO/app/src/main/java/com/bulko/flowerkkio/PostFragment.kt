package com.bulko.flowerkkio

//import android.content.Context
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import androidx.fragment.app.Fragment
//
//class PostFragment : Fragment() {
//    lateinit var mainActivity: MainActivity
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        // 2. Context를 액티비티로 형변환해서 할당
//        mainActivity = context as MainActivity
//    }
//
//    private lateinit var scrapBtn: Button
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val v = inflater.inflate(R.layout.mypost_layout, container, false)
//        return v
//    }
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
////
////        scrapBtn.setOnClickListener {
////            (parentFragment as ProfileFragment).scrap()
////        }
//    }
//}
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment

class PostFragment : Fragment() {
    lateinit var mainActivity: MainActivity
    lateinit var myPost1: ImageView
    lateinit var myPost2: ImageView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 2. Context를 액티비티로 형변환해서 할당
        mainActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.mypost_layout, container, false)
        myPost1 = v.findViewById(R.id.myPost1)
        myPost2 = v.findViewById(R.id.myPost2)
        myPost1.setOnClickListener {
            Toast.makeText(mainActivity, "게시글 1 선택", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), PostBottomActivity::class.java).apply {
                putExtra("POST_ID", 1L)
            }
            startActivity(intent)
        }
        myPost2.setOnClickListener {
            Toast.makeText(mainActivity, "게시글 2 선택", Toast.LENGTH_SHORT).show()
        }
        return v
    }
}
