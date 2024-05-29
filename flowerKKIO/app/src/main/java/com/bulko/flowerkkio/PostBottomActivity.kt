package com.bulko.flowerkkio

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PostBottomActivity : AppCompatActivity() {
    // private lateinit var binding: ActivityPostViewBinding

    private lateinit var like_button: ImageView
    private lateinit var bookmark_button: ImageView
    private lateinit var comment_button: ImageView
    private lateinit var plant_info: ImageView
    private lateinit var back_button: ImageView

    private var isLiked: Boolean = false
    private var isBookmarked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_bottom)

        like_button = findViewById(R.id.like_button)
        bookmark_button = findViewById(R.id.bookmark_button)
        comment_button = findViewById(R.id.comment_button)
        plant_info = findViewById(R.id.plant_info)

        back_button = findViewById(R.id.back_button)



        val postId = intent.getLongExtra("POST_ID", -1)

        if (postId == -1L) {
            Toast.makeText(this, "Invalid Post ID", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        Log.d("PostBottomActivity", postId.toString())


        if (postId == 1L) {
            Log.d("PostBottomActivity", "1")

            val selectedFragment = PostViewOneFragment().apply {
                arguments = Bundle().apply {
                    putLong("POST_ID", postId)
                }
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.host_fragment, selectedFragment)
                .commit()
        }

        if (postId == 2L) {
            Log.d("PostBottomActivity", "2")

            val selectedFragment = PostViewTwoFragment().apply {
                arguments = Bundle().apply {
                    putLong("POST_ID", postId)
                }
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.host_fragment, selectedFragment)
                .commit()
        }

        if (postId == 3L) {
            Log.d("PostBottomActivity", postId.toString())

            val selectedFragment = PostViewTwoFragment().apply {
                arguments = Bundle().apply {
                    putLong("POST_ID", postId)
                }
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.host_fragment, selectedFragment)
                .commit()
        }




        // 초기 상태 설정
        updateLikeButton()
        updateBookmarkButton()

        like_button.setOnClickListener {
            // 좋아요 버튼이 클릭되었을 때 할 작업을 여기에 추가
            toggleLike()
        }

        bookmark_button.setOnClickListener {
            // 북마크 버튼이 클릭되었을 때 할 작업을 여기에 추가
            toggleBookmark()
        }

        comment_button.setOnClickListener {
            // 댓글 버튼이 클릭되었을 때 할 작업을 여기에 추가
        }

        plant_info.setOnClickListener {
            if(postId == 1L) {
                Log.d("PostBottom.plant_info", postId.toString())

                val selectedFragment = MoreFlantFragment().apply {
                    arguments = Bundle().apply {
                        putLong("POST_ID", postId)
                    }
                }
                supportFragmentManager.beginTransaction()
                    .replace(R.id.host_fragment, selectedFragment)
                    .commit()
            }
        }

        back_button.setOnClickListener {
            val msg = "Move back"
            Toast.makeText(this@PostBottomActivity, msg, Toast.LENGTH_SHORT).show()
            // 현재 Activity를 종료하여 이전 Activity로 이동
            finish()
        }
    }

    private fun toggleLike() {
        isLiked = !isLiked
        updateLikeButton()
        // 여기서 서버나 데이터베이스에 좋아요 상태를 저장하는 작업을 수행
    }

    private fun toggleBookmark() {
        isBookmarked = !isBookmarked
        updateBookmarkButton()
        // 여기서 서버나 데이터베이스에 북마크 상태를 저장하는 작업을 수행
    }

    private fun updateLikeButton() {
        if (isLiked) {
            like_button.setImageResource(R.drawable.like_fill)
        } else {
            like_button.setImageResource(R.drawable.like)
        }
    }

    private fun updateBookmarkButton() {
        if (isBookmarked) {
            bookmark_button.setImageResource(R.drawable.bookmark_fill)
        } else {
            bookmark_button.setImageResource(R.drawable.bookmark)
        }
    }


    /* 좋아요 카운트 구현 코드
    private fun favoriteEvent(position: Int) {
        val tsDoc = fireStore.collection("posts").document(postUidList[position])
        fireStore.runTransaction { transition ->
            val postDto = transition.get(tsDoc).toObject(PostDto::class.java)

            // 좋아요가 눌린 경우
            if (postDto!!.favorite.containsKey(uid)) {
                postDto.favoriteCount -= 1
                postDto.favorite.remove(uid)
            } else {    // 눌리지 않은 경우
                postDto.favoriteCount += 1
                postDto.favorite[uid!!] = true
            }

            transition.set(tsDoc, postDto)
        }
    }
*/
}