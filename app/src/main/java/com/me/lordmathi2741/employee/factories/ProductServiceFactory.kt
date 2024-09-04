package com.me.lordmathi2741.employee.factories

import com.me.lordmathi2741.employee.contants.Constants
import com.me.lordmathi2741.employee.service.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProductServiceFactory {
    fun createProductService() : ProductService{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductService::class.java)
    }
}