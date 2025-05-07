package com.japheth.furnymart.model

data class CartItem(
    val product: Product,
    var quantity: Int = 1
)
