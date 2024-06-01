package com.bulko.flowerkkio


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.content.Intent
import android.widget.Button
import android.widget.ImageView



class HomeFragment : Fragment() {
    private lateinit var interest1: ImageView
    private lateinit var interest2: ImageView
    private lateinit var interest3: ImageView
    private lateinit var interest4: ImageView

    private lateinit var back_button: ImageView
    private lateinit var new_post_btn: Button


    private lateinit var homeBtn: ImageButton
    private lateinit var subscribeBtn: ImageButton
    private lateinit var profileBtn: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        interest1 = view.findViewById(R.id.interest1)
        interest2 = view.findViewById(R.id.interest2)
        interest3 = view.findViewById(R.id.interest3)
        interest4 = view.findViewById(R.id.interest4)

        back_button = view.findViewById(R.id.back_button)
        new_post_btn = view.findViewById(R.id.newPostBtn)

        // 여기서 관련된 버튼 및 뷰들의 클릭 이벤트 등을 설정할 수 있습니다.
        interest1.setOnClickListener {
            openPostBottomActivity(1L)
        }

        interest2.setOnClickListener {
            openPostBottomActivity(2L)
        }

        interest3.setOnClickListener {
            openPostBottomActivity(3L)
        }

        interest4.setOnClickListener {
            openPostBottomActivity(4L)
        }

        back_button.setOnClickListener {
            val msg = "Move back"
            Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
            // 현재 Fragment를 제거하여 이전 Fragment로 이동
            requireActivity().supportFragmentManager.popBackStack()
        }

        new_post_btn.setOnClickListener{
            val intent = Intent(requireContext(), CreatePostActivity::class.java)

            // 만약 추가적인 데이터를 전달해야 한다면 아래와 같이 데이터를 Intent에 추가할 수 있습니다
            // intent.putExtra("key", value)

            // PostViewActivity 시작
            startActivity(intent)
        }


    }

    private fun loadFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_view, fragment)
            .commit()
    }

    private fun openPostBottomActivity(postId: Long) {
        val intent = Intent(requireContext(), PostBottomActivity::class.java).apply {
            putExtra("POST_ID", postId)
        }
        startActivity(intent)

    }



}