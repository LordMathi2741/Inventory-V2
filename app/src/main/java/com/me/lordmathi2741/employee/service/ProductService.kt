package com.me.lordmathi2741.employee.service

import com.me.lordmathi2741.employee.contants.Constants
import com.me.lordmathi2741.employee.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {
    @GET(Constants.BASE_URL + Constants.ENDPOINT_PRODUCT_PATH)
    suspend fun getProducts() : List<Product>
}