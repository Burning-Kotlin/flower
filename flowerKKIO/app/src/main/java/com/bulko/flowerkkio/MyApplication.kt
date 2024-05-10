package com.bulko.flowerkkio

import android.app.Application
import com.kakao.sdk.common.KakaoSdk


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 다른 초기화 코드들

        // Kakao SDK 초기화
        KakaoSdk.init(this, "d34e53f62af053c41fee16c3d359090c")
    }
}