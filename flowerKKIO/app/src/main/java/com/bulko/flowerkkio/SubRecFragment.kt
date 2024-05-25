package com.bulko.flowerkkio

import android.content.Context
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment

class SubRecFragment : Fragment(), View.OnClickListener {

    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 2. Context를 액티비티로 형변환해서 할당
        mainActivity = context as MainActivity
    }
    private lateinit var backBtn_subrec: ImageButton
    private lateinit var menubar_subrec: ImageButton
    private lateinit var subscribe_now_small: ImageButton
    private lateinit var subscribe_now_regular: ImageButton
    private lateinit var subscribe_now_large: ImageButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.sub_rec_layout, container, false)
        backBtn_subrec = v.findViewById(R.id.backBtn_subrec)
        menubar_subrec = v.findViewById(R.id.menubar_subrec)
        subscribe_now_small = v.findViewById(R.id.subscribe_now_small)
        subscribe_now_regular = v.findViewById(R.id.subscribe_now_regular)
        subscribe_now_large = v.findViewById(R.id.subscribe_now_large)

        backBtn_subrec.setOnClickListener {
            Toast.makeText(mainActivity, "백버튼 눌림", Toast.LENGTH_SHORT).show()
        }
        menubar_subrec.setOnClickListener {
            Toast.makeText(mainActivity, "메뉴바 눌림", Toast.LENGTH_SHORT).show()
        }
        subscribe_now_small.setOnClickListener {
            startActivity(Intent(this@SubRecFragment.mainActivity, SubSmallActivity::class.java))
        }
        subscribe_now_regular.setOnClickListener {
            startActivity(Intent(this@SubRecFragment.mainActivity, SubRegularActivity::class.java))
        }
        subscribe_now_large.setOnClickListener {
            startActivity(Intent(this@SubRecFragment.mainActivity, SubLargeActivity::class.java))
        }
        return v
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}