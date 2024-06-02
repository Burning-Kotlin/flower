package com.bulko.flowerkkio
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreatePostActivity : AppCompatActivity() {
    private val PICK_IMAGE_REQUEST = 1
    private var selectedImageUri: Uri? = null
    private lateinit var postRepository: PostRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        postRepository = PostRepository(this)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val titleEditText = findViewById<EditText>(R.id.titleEditText)
        val contentEditText = findViewById<EditText>(R.id.contentEditText)
        val addInfoButton = findViewById<Button>(R.id.addInfoButton)
        val submitButton = findViewById<Button>(R.id.submitButton)

        imageView.setOnClickListener {
            openImagePicker()
        }

        submitButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val content = contentEditText.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty() && selectedImageUri != null) {
                val postId = postRepository.addPost(title, content, selectedImageUri.toString())
                Toast.makeText(this, "게시물이 저장되었습니다. ID: $postId", Toast.LENGTH_SHORT).show()
                // 새로 생성된 게시물 ID를 사용하여 다른 액티비티로 이동
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("POST_ID", postId)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "제목, 내용, 이미지를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        addInfoButton.setOnClickListener {
            // 추가 정보를 입력하는 기능 구현
            val intent = Intent(this, AddInfoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun openImagePicker() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            selectedImageUri = data.data
            val imageView = findViewById<ImageView>(R.id.imageView)
            imageView.setImageURI(selectedImageUri)
            Log.d("SUCCESS", "onActivityResult photo uri: $selectedImageUri")
        }
    }
}
