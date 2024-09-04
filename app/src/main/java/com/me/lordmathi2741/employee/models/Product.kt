package com.me.lordmathi2741.employee.models

data class Product (
    val id: Long,
    val name: String,
    val description: String,
    val price: Double,
    val quantity: Int,
    val imgUrl: String
)