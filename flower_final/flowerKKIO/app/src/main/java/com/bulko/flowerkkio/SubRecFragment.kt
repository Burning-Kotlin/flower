package com.bulko.flowerkkio

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bulko.flowerkkio.databinding.SubRecLayoutBinding
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class SubRecFragment : Fragment(), View.OnClickListener {
    private lateinit var mainActivity: MainActivity
    private lateinit var binding: SubRecLayoutBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = SubRecLayoutBinding.inflate(inflater, container, false)

        binding.backBtnSubrec.setOnClickListener {
            Toast.makeText(mainActivity, "백버튼 눌림", Toast.LENGTH_SHORT).show()
        }
        binding.menubarSubrec.setOnClickListener {
            Toast.makeText(mainActivity, "메뉴바 눌림", Toast.LENGTH_SHORT).show()
        }
        binding.subscribeNowSmall.setOnClickListener {
            startActivity(Intent(this@SubRecFragment.mainActivity, SubSmallActivity::class.java))
        }
        binding.subscribeNowRegular.setOnClickListener {
            startActivity(Intent(this@SubRecFragment.mainActivity, SubRegularActivity::class.java))
        }
        binding.subscribeNowLarge.setOnClickListener {
            startActivity(Intent(this@SubRecFragment.mainActivity, SubLargeActivity::class.java))
        }

        fetchWeatherData()

        return binding.root
    }

    private fun fetchWeatherData() {
        val city = "Seoul"
        val apiKey = "748f476c3dbfd458b3549827c5f7893b" // 여기에 실제 API 키를 넣으세요
        val lang = "kr"
        val apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apiKey&lang=$lang&units=metric"

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val url = URL(apiUrl)
                val connection = url.openConnection() as HttpURLConnection

                connection.requestMethod = "GET"

                val responseCode = connection.responseCode
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    val bufferedReader = BufferedReader(InputStreamReader(connection.inputStream))
                    val response = StringBuilder()
                    var line: String?

                    while (bufferedReader.readLine().also { line = it } != null) {
                        response.append(line)
                    }

                    bufferedReader.close()

                    val data = JsonParser.parseString(response.toString()).asJsonObject
                    val main = data.getAsJsonObject("main")
                    val temperature = main.get("temp").asDouble

                    withContext(Dispatchers.Main) {
                        val weatherText = "오늘 날씨 $temperature °C엔 이런 꽃은 어때요? ✨"
                        binding.weatherTextView.text = weatherText
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(mainActivity, "GET 요청 실패: $responseCode", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(mainActivity, "에러 발생: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onClick(v: View?) {
        // TODO: Not yet implemented
    }
}
