package com.bulko.flowerkkio

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class SubSmallActivity : AppCompatActivity() {

    // 체크박스 꽃 선택
    lateinit var cb_flower1_small: CheckBox
    lateinit var cb_flower2_small: CheckBox
    lateinit var cb_flower3_small: CheckBox
    lateinit var cb_flower4_small: CheckBox
    lateinit var cb_flower5_small: CheckBox
    lateinit var cb_flower6_small: CheckBox
    lateinit var cb_flower7_small: CheckBox

    // 첫 수령 희망일 선택
    lateinit var datePicker_small: DatePicker

    // 라디오버튼 구독 주기 선택
    lateinit var radio_group_small: RadioGroup
    lateinit var radio_once_small: RadioButton
    lateinit var radio_twice_small: RadioButton
    lateinit var radio_fourtimes_small: RadioButton

    // 버튼
    lateinit var subscribe_small: Button
    lateinit var backBtn_subsmall: ImageButton

    lateinit var subscribe_option: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.subscribe_small_layout)

        backBtn_subsmall = findViewById(R.id.backBtn_subsmall)
        subscribe_small = findViewById(R.id.subscribe_small)

        cb_flower1_small = findViewById(R.id.cb_flower1_small)
        cb_flower2_small = findViewById(R.id.cb_flower2_small)
        cb_flower3_small = findViewById(R.id.cb_flower3_small)
        cb_flower4_small = findViewById(R.id.cb_flower4_small)
        cb_flower5_small = findViewById(R.id.cb_flower5_small)
        cb_flower6_small = findViewById(R.id.cb_flower6_small)
        cb_flower7_small = findViewById(R.id.cb_flower7_small)

        radio_group_small = findViewById(R.id.radio_group_small)
        radio_once_small = findViewById(R.id.radio_once_small)
        radio_twice_small = findViewById(R.id.radio_twice_small)
        radio_fourtimes_small = findViewById(R.id.radio_fourtimes_small)

//        subscribe_option = ""

//        subscribe_small.setOnClickListener {
//
//            if (cb_flower1_small.isChecked) {
//                subscribe_option += cb_flower1_small.text.toString() + ", "
//            }
//            if (cb_flower2_small.isChecked) {
//                subscribe_option += cb_flower2_small.text.toString() + ", "
//            }
//            if (cb_flower3_small.isChecked) {
//                subscribe_option += cb_flower3_small.text.toString() + ", "
//            }
//            if (cb_flower4_small.isChecked) {
//                subscribe_option += cb_flower4_small.text.toString() + ", "
//            }
//            if (cb_flower5_small.isChecked) {
//                subscribe_option += cb_flower5_small.text.toString() + ", "
//            }
//            if (cb_flower6_small.isChecked) {
//                subscribe_option += cb_flower6_small.text.toString() + ", "
//            }
//            if (cb_flower7_small.isChecked) {
//                subscribe_option += cb_flower7_small.text.toString() + ", "
//            }
//
//            // 선택된 라디오버튼 값에 따라 구독 주기를 추가
//            if (radio_once_small.isChecked) {
//                subscribe_option += " (월 1회 정기구독)"
//            } else if (radio_twice_small.isChecked) {
//                subscribe_option += " (월 2회 정기구독)"
//            } else if (radio_fourtimes_small.isChecked) {
//                subscribe_option += " (월 4회 정기구독)"
//            } else {
//                // 라디오버튼을 선택하지 않은 경우에 대한 처리
//                Toast.makeText(this, "구독 주기를 선택하세요!", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//            // 선택된 체크박스가 없을 경우에는 Toast 메시지로 알림
//            if (subscribe_option.isEmpty()) {
//                Toast.makeText(this, "꽃을 선택하세요!", Toast.LENGTH_SHORT).show()
//            } else {
//                // 선택된 체크박스의 텍스트 값을 subscribe_option에 추가하고 Toast 메시지로 알림
//                subscribe_option = subscribe_option.removeSuffix(", ") // 마지막 쉼표 제거
//                Toast.makeText(this, "선택한 꽃: $subscribe_option", Toast.LENGTH_SHORT).show()
//            }
//
//            // subscribe_option 값을 출력하거나 원하는 동작을 수행
//        }

        backBtn_subsmall.setOnClickListener {
            Toast.makeText(this@SubSmallActivity, "뒤로 가기 버튼 눌림!", Toast.LENGTH_SHORT).show()
            finish()
        }
        subscribe_small.setOnClickListener() {
            Toast.makeText(this@SubSmallActivity, "Small 구독이 완료되었습니다!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}

