package com.bulko.flowerkkio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddInfoActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_info)

        val plantNameEditText = findViewById<EditText>(R.id.plantNameEditText)
        val purchaseLinkEditText = findViewById<EditText>(R.id.purchaseLinkEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            val plantName = plantNameEditText.text.toString()
            val purchaseLink = purchaseLinkEditText.text.toString()

            if (plantName.isNotEmpty() && purchaseLink.isNotEmpty()) {
                // 여기에 데이터를 저장하는 로직을 구현합니다.
                Toast.makeText(this, "추가 정보가 저장되었습니다.", Toast.LENGTH_SHORT).show()
                finish() // Activity를 종료하여 MainActivity로 돌아갑니다.
            } else {
                Toast.makeText(this, "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}