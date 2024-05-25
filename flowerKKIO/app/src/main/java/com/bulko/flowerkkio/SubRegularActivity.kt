package com.bulko.flowerkkio

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.service.autofill.ImageTransformation
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

class SubRegularActivity : AppCompatActivity() {

    // 체크박스 꽃 선택
    lateinit var cb_flower1_regular: CheckBox
    lateinit var cb_flower2_regular: CheckBox
    lateinit var cb_flower3_regular: CheckBox
    lateinit var cb_flower4_regular: CheckBox
    lateinit var cb_flower5_regular: CheckBox
    lateinit var cb_flower6_regular: CheckBox
    lateinit var cb_flower7_regular: CheckBox

    // 첫 수령 희망일 선택
    lateinit var datePicker_regular: DatePicker

    // 라디오버튼 구독 주기 선택
    lateinit var radio_group_regularl: RadioGroup
    lateinit var radio_once_regular: RadioButton
    lateinit var radio_twice_regular: RadioButton
    lateinit var radio_fourtimes_regular: RadioButton

    // 버튼
    lateinit var subscribe_regular: Button
    lateinit var backBtn_subregular:ImageButton

    lateinit var subscribe_option: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.subscribe_regular_layout)

        backBtn_subregular = findViewById(R.id.backBtn_subregular)
        subscribe_regular = findViewById(R.id.subscribe_regular)

        cb_flower1_regular = findViewById(R.id.cb_flower1_regular)
        cb_flower2_regular = findViewById(R.id.cb_flower2_regular)
        cb_flower3_regular = findViewById(R.id.cb_flower3_regular)
        cb_flower4_regular = findViewById(R.id.cb_flower4_regular)
        cb_flower5_regular = findViewById(R.id.cb_flower5_regular)
        cb_flower6_regular = findViewById(R.id.cb_flower6_regular)
        cb_flower7_regular = findViewById(R.id.cb_flower7_regular)

        radio_once_regular = findViewById(R.id.radio_once_regular)
        radio_twice_regular = findViewById(R.id.radio_twice_regular)
        radio_fourtimes_regular = findViewById(R.id.radio_fourtimes_regular)

        backBtn_subregular.setOnClickListener {
            Toast.makeText(this@SubRegularActivity, "뒤로 가기 버튼 눌림!", Toast.LENGTH_SHORT).show()
            finish()
        }
        subscribe_regular.setOnClickListener() {
            Toast.makeText(this@SubRegularActivity, "Regular 구독이 완료되었습니다!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}

