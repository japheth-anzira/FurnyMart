package com.japheth.furnymart.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import com.japheth.furnymart.model.CartItem
import com.japheth.furnymart.model.Product

class CartViewModel : ViewModel() {
    // Mutable list of cart items
    private val _cartItems = mutableStateOf<List<CartItem>>(emptyList())
    val cartItems: State<List<CartItem>> get() = _cartItems

    // Add an item to the cart
    fun addToCart(product: Product) {
        val existingItem = _cartItems.value.find { it.product.id == product.id }
        if (existingItem != null) {
            // If the item already exists, increase the quantity by 1
            val updatedItems = _cartItems.value.map {
                if (it.product.id == product.id) it.copy(quantity = it.quantity + 1) else it
            }
            _cartItems.value = updatedItems
        } else {
            // If the item doesn't exist, add it to the cart with quantity 1
            _cartItems.value = _cartItems.value + CartItem(product = product, quantity = 1)
        }
    }

    // Remove an item from the cart
    fun removeFromCart(product: Product) {
        _cartItems.value = _cartItems.value.filter { it.product.id != product.id }
    }

    // Get the total price of all items in the cart
    fun getTotalPrice(): Double {
        return _cartItems.value.sumOf { it.product.price * it.quantity }
    }

    // Clear all items from the cart
    fun clearCart() {
        _cartItems.value = emptyList()
    }
}
