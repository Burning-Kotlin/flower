package com.bulko.flowerkkio

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class EditProfileActivity : AppCompatActivity() {

    lateinit var profileImage_edit: ImageView
    lateinit var selectImgBtn: Button
    lateinit var backBtn_edit: ImageButton
    lateinit var saveProfileBtn: Button
    lateinit var newNickname: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile)

        profileImage_edit = findViewById(R.id.profileImage_edit)
        backBtn_edit = findViewById(R.id.backBtn_edit)
        saveProfileBtn = findViewById(R.id.saveProfileBtn)
//        selectImgBtn = findViewById(R.id.selectImgBtn)
        newNickname = findViewById(R.id.newNickname)

        backBtn_edit.setOnClickListener {
            Toast.makeText(this@EditProfileActivity, "뒤로 가기 버튼 눌림!", Toast.LENGTH_SHORT).show()
            finish()
        }

        saveProfileBtn.setOnClickListener {
            Toast.makeText(this@EditProfileActivity, "변경사항이 저장되었습니다!", Toast.LENGTH_SHORT).show()
            finish()
        }

        profileImage_edit.setOnClickListener {
            checkPermissionAndNavigateGallery()
        }
    }

    private fun checkPermissionAndNavigateGallery() {
        val permissions = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            arrayOf(android.Manifest.permission.READ_MEDIA_IMAGES, android.Manifest.permission.READ_MEDIA_VIDEO)
        } else {
            arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        if (permissions.all { ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED }) {
            navigateGallery()
        } else {
            if (permissions.any { shouldShowRequestPermissionRationale(it) }) {
                showPermissionContextPopup()
            } else {
                requestPermissions(permissions, 1000)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        Log.d("EditProfileActivity", "onRequestPermissionsResult called")
        Log.d("EditProfileActivity", "Request code: $requestCode, Permissions: ${permissions.joinToString()}, Grant results: ${grantResults.joinToString()}")

        when (requestCode) {
            1000 -> {
                if (grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                    Log.d("EditProfileActivity", "Permission granted")
                    navigateGallery()
                } else {
                    Log.d("EditProfileActivity", "Permission denied")
                    Toast.makeText(this, "권한을 거부하셨습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun navigateGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 2000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != Activity.RESULT_OK) return

        when (requestCode) {
            2000 -> {
                val selectedImageUri: Uri? = data?.data
                if (selectedImageUri != null) {
                    profileImage_edit.setImageURI(selectedImageUri)
                } else {
                    Toast.makeText(this, "사진을 가져오지 못했습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun showPermissionContextPopup() {
        AlertDialog.Builder(this)
            .setTitle("권한이 필요합니다.")
            .setMessage("프로필 이미지를 바꾸기 위해서는 갤러리 접근 권한이 필요합니다.")
            .setPositiveButton("동의하기") { _, _ ->
                val permissions = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                    arrayOf(android.Manifest.permission.READ_MEDIA_IMAGES, android.Manifest.permission.READ_MEDIA_VIDEO)
                } else {
                    arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                }
                requestPermissions(permissions, 1000)
            }
            .setNegativeButton("취소하기", null)
            .show()
    }
}
