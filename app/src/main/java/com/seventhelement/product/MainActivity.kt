package com.seventhelement.product

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.seventhelement.Services.ApiService
import com.seventhelement.Services.Servicegenerator
import com.seventhelement.model.value
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button=findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent=Intent(this,Productlistactivity::class.java);
            startActivity(intent)
        }
    }
}