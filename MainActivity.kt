package com.example.kotlinday2recyclerviewwe

import android.accounts.NetworkErrorException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var responselist: List<ResponseDTO> = listOf<ResponseDTO>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
     btnFetch.setOnClickListener {
         callApi()
     }
    }

    private fun callApi() {
        val apiService = Network.getInstance().create(ApiService::class.java)
        apiService.getPosts(etEnterId.text.toString().toInt())
            .enqueue(object : Callback<List<ResponseDTO>>{
                override fun onResponse(
                    call: Call<List<ResponseDTO>>,
                    response: Response<List<ResponseDTO>>
                ) {
                  responselist =  response.body()!!
                    setRecyclerview()
                }

                override fun onFailure(call: Call<List<ResponseDTO>>, t: Throwable) {

                }

            })

    }

    private fun setRecyclerview() {
      val adapter = Adapter(responselist)
        val linearLayoutManager =LinearLayoutManager(this)
        recyclerview.adapter = adapter
        recyclerview.layoutManager =linearLayoutManager
    }

}


