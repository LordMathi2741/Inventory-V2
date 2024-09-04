package com.me.lordmathi2741.employee.singleton

import com.me.lordmathi2741.employee.factories.ProductServiceFactory
import com.me.lordmathi2741.employee.models.Product
import com.me.lordmathi2741.employee.service.ProductService

class Configuration private constructor() {
    companion object{
        private val instance : Configuration? = null
        fun getInstance() : Configuration {
            return instance ?: Configuration()
        }
    }
    fun setUpRetrofit(): ProductService {
        val factory = ProductServiceFactory
        return factory.createProductService()
    }
    suspend fun getProducts(service: ProductService) : List<Product>{
        val products = service.getProducts()
        return products
    }


}