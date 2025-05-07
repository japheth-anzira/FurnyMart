package com.japheth.furnymart.ui.theme.screens.beds

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.japheth.furnymart.R

// Product and CartItem Models
data class Product(val id: Int, val name: String, val price: String, val imageRes: Int)
data class CartItem(val product: Product, var quantity: Int = 1)

// Cart ViewModel
class CartViewModel : ViewModel() {
    private val _cartItems = mutableStateListOf<CartItem>()
    val cartItems: List<CartItem> get() = _cartItems

    fun addToCart(product: Product) {
        val item = _cartItems.find { it.product.id == product.id }
        if (item != null) {
            item.quantity++
        } else {
            _cartItems.add(CartItem(product))
        }
    }

    fun removeFromCart(productId: Int) {
        _cartItems.removeAll { it.product.id == productId }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BedsScreen(navController: NavController, cartViewModel: CartViewModel = viewModel()) {
    val mContext = LocalContext.current

    val products = listOf(
        Product(1, "Sofa", "Ksh.12000", R.drawable.newsofa),
        Product(2, "Bed", "Ksh.17000", R.drawable.bed1),
        Product(3, "Table", "Ksh.7500", R.drawable.table1),
        Product(4, "Chair", "Ksh.5350", R.drawable.chair1)
    )

    val cartCount by remember { derivedStateOf { cartViewModel.cartItems.sumOf { it.quantity } } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Beds") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("home") }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate("cart") }) {
                        BadgedBox(
                            badge = {
                                if (cartCount > 0) {
                                    Badge { Text(cartCount.toString()) }
                                }
                            }
                        ) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
                        }
                    }

                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFFF5F5F5),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                IconButton(onClick = { navController.navigate("home") }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back to Home")
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { navController.navigate("cart") }) {
                    Icon(Icons.Default.ShoppingCart, contentDescription = "Go to Cart")
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(18.dp)
        ) {
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(Color.Gray),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        "Transform your bedroom into a heaven of comfort! Made from high-quality materials, our beds offer the perfect blend of durability and elegance - designed to give you the restful sleep you deserve.",
                        fontWeight = FontWeight.Bold,
                        color = Color.Red
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(products) { product ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Image(
                            painter = painterResource(product.imageRes),
                            contentDescription = product.name,
                            modifier = Modifier
                                .size(130.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillBounds
                        )
                        Text(product.price, fontSize = 15.sp)
                        Button(
                            onClick = { cartViewModel.addToCart(product) },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(Color.Unspecified)
                        ) {
                            Text("Add to Cart")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CartScreen(cartViewModel: CartViewModel, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Your Cart", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))
        if (cartViewModel.cartItems.isEmpty()) {
            Text("Cart is empty")
        } else {
            cartViewModel.cartItems.forEach { item ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = item.product.imageRes),
                        contentDescription = item.product.name,
                        modifier = Modifier.size(60.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(item.product.name)
                        Text("Price: ${item.product.price}")
                        Text("Quantity: ${item.quantity}")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { cartViewModel.removeFromCart(item.product.id) }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Remove")
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { /* Implement checkout logic */ }) {
                Text("Checkout")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BedsScreenPreview() {
    BedsScreen(navController = rememberNavController())
}
