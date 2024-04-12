package com.seventhelement.model

data class value(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)