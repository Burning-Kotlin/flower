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

class SubLargeActivity : AppCompatActivity() {

    // 체크박스 꽃 선택
    lateinit var cb_flower1_large: CheckBox
    lateinit var cb_flower2_large: CheckBox
    lateinit var cb_flower3_large: CheckBox
    lateinit var cb_flower4_large: CheckBox
    lateinit var cb_flower5_large: CheckBox
    lateinit var cb_flower6_large: CheckBox
    lateinit var cb_flower7_large: CheckBox

    // 첫 수령 희망일 선택
    lateinit var datePicker_large: DatePicker

    // 라디오버튼 구독 주기 선택
    lateinit var radio_group_large: RadioGroup
    lateinit var radio_once_large: RadioButton
    lateinit var radio_twice_large: RadioButton
    lateinit var radio_fourtimes_large: RadioButton

    // 버튼
    lateinit var subscribe_large: Button
    lateinit var backBtn_sublarge: ImageButton

//    lateinit var subscribe_option: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.subscribe_large_layout)

        backBtn_sublarge = findViewById(R.id.backBtn_sublarge)
        subscribe_large = findViewById(R.id.subscribe_large)

        cb_flower1_large = findViewById(R.id.cb_flower1_large)
        cb_flower2_large = findViewById(R.id.cb_flower2_large)
        cb_flower3_large = findViewById(R.id.cb_flower3_large)
        cb_flower4_large = findViewById(R.id.cb_flower4_large)
        cb_flower5_large = findViewById(R.id.cb_flower5_large)
        cb_flower6_large = findViewById(R.id.cb_flower6_large)
        cb_flower7_large = findViewById(R.id.cb_flower7_large)

        radio_once_large = findViewById(R.id.radio_once_large)
        radio_twice_large = findViewById(R.id.radio_twice_large)
        radio_fourtimes_large = findViewById(R.id.radio_fourtimes_large)

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

        backBtn_sublarge.setOnClickListener {
            Toast.makeText(this@SubLargeActivity, "뒤로 가기 버튼 눌림!", Toast.LENGTH_SHORT).show()
            finish()
        }
        subscribe_large.setOnClickListener() {
            Toast.makeText(this@SubLargeActivity, "Large 구독이 완료되었습니다!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}

