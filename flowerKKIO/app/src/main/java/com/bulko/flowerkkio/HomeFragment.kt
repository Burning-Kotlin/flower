package com.bulko.flowerkkio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton


class HomeFragment : Fragment() {
    private lateinit var interest1: ImageButton
    private lateinit var interest2: ImageButton
    private lateinit var interest3: ImageButton
    private lateinit var interest4: ImageButton

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

        homeBtn = view.findViewById(R.id.homeBtn)
        subscribeBtn = view.findViewById(R.id.subscribeBtn)
        profileBtn = view.findViewById(R.id.profileBtn)

        // 여기서 관련된 버튼 및 뷰들의 클릭 이벤트 등을 설정할 수 있습니다.
        interest1.setOnClickListener {
            // Interest 1 클릭 처리
        }

        interest2.setOnClickListener {
            // Interest 2 클릭 처리
        }

        interest3.setOnClickListener {
            // Interest 3 클릭 처리
        }

        interest4.setOnClickListener {
            // Interest 4 클릭 처리
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