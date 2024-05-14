package com.bulko.flowerkkio


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.content.Context
import android.content.Intent
import android.widget.ImageView



class HomeFragment : Fragment() {
    private lateinit var interest1: ImageView
    private lateinit var interest2: ImageView
    private lateinit var interest3: ImageView
    private lateinit var interest4: ImageView

    private lateinit var back_button: ImageView

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

        homeBtn = view.findViewById(R.id.homeBtn)
        subscribeBtn = view.findViewById(R.id.subscribeBtn)
        profileBtn = view.findViewById(R.id.profileBtn)

        // 여기서 관련된 버튼 및 뷰들의 클릭 이벤트 등을 설정할 수 있습니다.
        interest1.setOnClickListener {
            val intent = Intent(requireContext(), PostViewActivity::class.java)

            // 만약 추가적인 데이터를 전달해야 한다면 아래와 같이 데이터를 Intent에 추가할 수 있습니다
            // intent.putExtra("key", value)

            // PostViewActivity 시작
            startActivity(intent)
        }

        interest2.setOnClickListener {
            // PostViewActivity로 이동하는 Intent 생성
            val intent = Intent(requireContext(), PostViewActivity::class.java)

            // 만약 추가적인 데이터를 전달해야 한다면 아래와 같이 데이터를 Intent에 추가할 수 있습니다
            // intent.putExtra("key", value)

            // PostViewActivity 시작
            startActivity(intent)
        }

        interest3.setOnClickListener {
            val intent = Intent(requireContext(), PostViewActivity::class.java)

            // 만약 추가적인 데이터를 전달해야 한다면 아래와 같이 데이터를 Intent에 추가할 수 있습니다
            // intent.putExtra("key", value)

            // PostViewActivity 시작
            startActivity(intent)
        }

        interest4.setOnClickListener {
            // Interest 4 클릭 처리
        }

        // ImageView에 OnClickListener 설정
        // ImageView에 OnClickListener 설정
        back_button.setOnClickListener {

            val msg = "Move back"
            Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
            // 현재 Fragment를 제거하여 이전 Fragment로 이동
            requireActivity().supportFragmentManager.popBackStack()
        }

        // Home 버튼 클릭 시 HomeFragment 다시 로드 (재차 로드 방지를 위해 필요에 따라 조건을 추가)
        homeBtn.setOnClickListener {
            // 현재 HomeFragment가 활성화되어 있지 않을 때만 로드
            if (requireActivity().supportFragmentManager.findFragmentById(R.id.main_view) !is HomeFragment) {
                loadFragment(HomeFragment())
            }
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
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_view, fragment)
            .commit()
    }

}