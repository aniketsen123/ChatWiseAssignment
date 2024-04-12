package com.seventhelement.Services

import com.seventhelement.model.value
import retrofit2.http.GET

interface ApiService {

    @GET("/products")
    fun getlist():retrofit2.Call<value>
}