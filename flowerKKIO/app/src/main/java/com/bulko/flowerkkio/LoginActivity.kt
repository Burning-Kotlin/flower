package com.bulko.flowerkkio

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.bulko.flowerkkio.community.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.oAuthCredential
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient


private const val TAG = "LoginActivity"
private lateinit var auth: FirebaseAuth
private var profileImage: String? = null
private var nickname: String? = null


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_main)

        // Firebase 초기화
        Firebase.initialize(this)

        // Firebase Authentication 초기화
        auth = FirebaseAuth.getInstance()

        // 로그인 공통 callback 구성
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                // 로그인 실패
                Log.w(TAG, "Kakao sign in failed", error)
            } else if (token != null) {
                // 로그인 성공
                Log.d(TAG, "Kakao sign in succeeded")

                // Firebase에 Kakao OAuth 토큰으로 로그인
                val providerBuilder = OAuthProvider.newBuilder("oidc.flower")
                val providerId = "oidc.flower" // As registered in Firebase console.

                val credential = oAuthCredential(providerId) {
                    setIdToken(token.idToken)// ID token from OpenID Connect flow.
                }

                Firebase.auth
                    .signInWithCredential(credential)
                    .addOnSuccessListener { authResult ->
                        // Firebase에 로그인 성공
                        val user = authResult.user
                        Log.d(TAG, "Firebase sign in succeeded: $user")
                        // SelectUserActivity로 이동
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish() // LoginActivity는 종료
                    }
                    .addOnFailureListener { e ->
                        // 로그인 실패
                        Log.w(TAG, "Firebase sign in failed", e)
                    }
            }
        }

        // 카카오 로그인 버튼
        val kakaoLoginBtn = findViewById<ImageButton>(R.id.kakao_login)
        kakaoLoginBtn.setOnClickListener {
            // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
            UserApiClient.instance.run {
                if (isKakaoTalkLoginAvailable(this@LoginActivity)) {
                    loginWithKakaoTalk(this@LoginActivity, callback = callback)
                } else {
                    loginWithKakaoAccount(this@LoginActivity, callback = callback)
                }
            }
        }
    }
}