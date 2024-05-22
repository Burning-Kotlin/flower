package com.bulko.flowerkkio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.bulko.flowerkkio.databinding.ActivityNaviBinding


private const val TAG_HOME = "home_fragment"
private const val TAG_SUBSCRIBE = "subscribe_fragment"
private const val TAG_MY_PAGE = "my_page_fragment"


class NaviActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(TAG_HOME, HomeFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.HomeFragment -> setFragment(TAG_HOME, HomeFragment())
                R.id.SubscribeFragment -> setFragment(TAG_SUBSCRIBE, SubscribeFragment())
                R.id.ProfileFragment-> setFragment(TAG_MY_PAGE, ProfileFragment())
            }
            true
        }

    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val home = manager.findFragmentByTag(TAG_HOME)
        val subscribe = manager.findFragmentByTag(TAG_SUBSCRIBE)
        val myPage = manager.findFragmentByTag(TAG_MY_PAGE)

        if (home != null){
            fragTransaction.hide(home)
        }

        if (subscribe != null){
            fragTransaction.hide(subscribe)
        }

        if (myPage != null) {
            fragTransaction.hide(myPage)
        }

        if (tag == TAG_HOME) {
            if (home!=null){
                fragTransaction.show(home)
            }
        }
        else if (tag == TAG_SUBSCRIBE) {
            if (subscribe != null) {
                fragTransaction.show(subscribe)
            }
        }

        else if (tag == TAG_MY_PAGE){
            if (myPage != null){
                fragTransaction.show(myPage)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}