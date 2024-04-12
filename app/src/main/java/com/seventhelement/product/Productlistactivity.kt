package com.seventhelement.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seventhelement.Services.ApiService
import com.seventhelement.Services.Servicegenerator
import com.seventhelement.model.value
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Productlistactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productlistactivity)
        val serviceGenerator= Servicegenerator.buildService(ApiService::class.java)
        val call=serviceGenerator.getlist()
        val progressBar=findViewById<ProgressBar>(R.id.progressBar)
        call.enqueue(object: Callback<value> {
            override fun onResponse(
                call: Call<value>,
                response: Response<value>
            ) {
                progressBar.visibility= View.GONE
                val recyclerView: RecyclerView = findViewById(R.id.rr)
                recyclerView.layoutManager = LinearLayoutManager(this@Productlistactivity)
                val adapter = Adapter(response.body()!!.products)
                recyclerView.adapter = adapter
               // Toast.makeText(this@Productlistactivity,response.body().toString(), Toast.LENGTH_SHORT).show();
                Log.d("ANS",response.body().toString())
            }
            override fun onFailure(call: Call<value>, t: Throwable) {
                progressBar.visibility= View.GONE
                Log.d("ANS",t.message.toString())
            }
        })
    }
}