package com.japheth.furnymart.ui.theme.screens.tables

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.japheth.furnymart.R
import com.japheth.furnymart.ui.theme.screens.beds.CartViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.japheth.furnymart.ui.theme.screens.beds.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TablesScreen(
    navController: NavController,
    cartViewModel: CartViewModel = viewModel()
) {
    val products = listOf(
        Product(1, "Sofa", "Ksh.12000", R.drawable.newsofa),
        Product(2, "Bed", "Ksh.17000", R.drawable.bed1),
        Product(3, "Table", "Ksh.7500", R.drawable.table1),
        Product(4, "Chair", "Ksh.5350", R.drawable.chair1)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tables") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("home") }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
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
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.ArrowBack, contentDescription = "Back to Home") },
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
                    selected = false,
                    onClick = { navController.navigate("cart") }
                )
            }
        },
        content = { padding ->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
            ) {
                val mContext = LocalContext.current

                // Horizontal scroll of products
                LazyColumn(
                    modifier = Modifier.padding(16.dp)
                ) {
                    items(products.chunked(2)) { rowProducts ->
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            rowProducts.forEach { product ->
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = product.imageRes),
                                        contentDescription = product.name,
                                        modifier = Modifier
                                            .size(130.dp)
                                            .clip(shape = RoundedCornerShape(7.dp)),
                                        contentScale = ContentScale.FillBounds
                                    )
                                    Text(text = product.price, fontSize = 15.sp)

                                    Button(
                                        onClick = { cartViewModel.addToCart(product) },
                                        shape = RoundedCornerShape(10.dp),
                                        colors = ButtonDefaults.buttonColors(Color.Unspecified)
                                    ) {
                                        Text(text = "Add to Cart")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TablesScreenPreview() {
    TablesScreen(navController = rememberNavController())
}
