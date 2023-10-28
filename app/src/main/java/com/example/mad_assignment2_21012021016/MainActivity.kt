package com.example.mad_assignment2_21012021016

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KProperty as KProperty1

private var Any.text: String
    get() {
        TODO()
    }
    set(r){

    }

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        fetchWeatherData()
    }

    private fun setContentView(root: Any) {
        TODO("Not yet implemented")
    }


    private fun fetchWeatherData() {
        val retrofit=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build().create(ApiInterface::class.java)

//        val response = retrofit.getWeatherData("surat","")
        val call = retrofit.getWeather("surat","b8e423e6a8398c16ad2246566acce834","metric")

        call.enqueue(object : Callback<WeatherApp> {
            override fun onResponse(call: Call<WeatherApp>, response: Response<WeatherApp>) {
                val responseBody=response.body()
                if(response.isSuccessful && responseBody != null){
                    val temperature =responseBody.main.temp.toString()
                    binding.temp.text="$temperature"

//                    Log.d("TAG","onResponse: $temperature")
                }
            }

            override fun onFailure(call: Call<WeatherApp>, t: Throwable) {
                // Handle network errors
            }
        })

    }

    class ApiInterface {
        fun getWeather(city: String, appid: String, unit:String): Any {
                            TODO("Not yet implemented")
        }

    }
}

private operator fun Any.getValue(mainActivity: MainActivity, property: KProperty1<*>): ActivityMainBinding {

    TODO("Not yet implemented")
}


class ActivityMainBinding {
    val temp: Any = TODO()
    val root: Any
        get() {
            TODO()
        }

    companion object {
        fun <LayoutInflater> inflate(layoutInflater: LayoutInflater) {

        }
    }

}


private fun Any.enqueue(callback: Callback<*>) {

}
