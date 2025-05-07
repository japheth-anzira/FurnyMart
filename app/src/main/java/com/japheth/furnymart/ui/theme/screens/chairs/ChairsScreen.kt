package com.japheth.furnymart.ui.theme.screens.chairs

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.japheth.furnymart.R
import com.japheth.furnymart.ui.theme.screens.beds.CartItem
import com.japheth.furnymart.ui.theme.screens.beds.CartViewModel
import com.japheth.furnymart.ui.theme.screens.beds.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChairsScreen(navController: NavController, cartViewModel: CartViewModel = viewModel()) {
    val products = listOf(
        Product(1, "Sofa", "Ksh.12000", R.drawable.newsofa),
        Product(2, "Bed", "Ksh.17000", R.drawable.bed1),
        Product(3, "Table", "Ksh.7500", R.drawable.table1),
        Product(4, "Chair", "Ksh.5350", R.drawable.chair1)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Chairs") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("home") }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate("cart") }) {
                        BadgedBox(
                            badge = {
                                if (cartViewModel.cartItems.isNotEmpty()) {
                                    Badge { Text("${cartViewModel.cartItems.size}") }
                                }
                            }
                        ) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
                        }
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.ArrowBack, contentDescription = "Back to Home") },
                    label = { Text("Back to Home") },
                    selected = false,
                    onClick = { navController.navigate("home") }
                )
                NavigationBarItem(
                    icon = {
                        BadgedBox(
                            badge = {
                                if (cartViewModel.cartItems.isNotEmpty()) {
                                    Badge { Text("${cartViewModel.cartItems.size}") }
                                }
                            }
                        ) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
                        }
                    },
                    label = { Text("Cart") },
                    selected = false,
                    onClick = { navController.navigate("cart") }
                )
            }
        },
        content = { padding ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(padding)
            ) {
                items(products) { product ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = product.imageRes),
                            contentDescription = product.name,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .size(140.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(product.name, fontWeight = FontWeight.Bold)
                        Text(product.price, fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        Button(
                            onClick = { cartViewModel.addToCart(product) },
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF607D8B))
                        ) {
                            Text("Add to Cart", color = Color.White)
                        }
                    }
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun ChairsScreenPreview() {
    ChairsScreen(navController = rememberNavController())
}