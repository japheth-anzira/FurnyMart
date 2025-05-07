package com.japheth.furnymart.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.japheth.furnymart.R
import com.japheth.furnymart.navigation.*
import com.japheth.furnymart.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        val mContext = LocalContext.current
        var selectedIndex by remember { mutableStateOf(0) }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("FurnyMart") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Orange,
                        titleContentColor = Color.White
                    ),
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar(containerColor = Orange) {
                    val itemColors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.White,
                        unselectedIconColor = Color.White,
                        selectedTextColor = Color.White,
                        unselectedTextColor = Color.White
                    )

                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                        label = { Text("Home") },
                        selected = selectedIndex == 0,
                        onClick = {
                            selectedIndex = 0
                            navController.navigate(ROUT_HOME)
                        },
                        colors = itemColors
                    )

                    NavigationBarItem(
                        icon = { Icon(Icons.Default.CheckCircle, contentDescription = "Products") },
                        label = { Text("Products") },
                        selected = selectedIndex == 1,
                        onClick = {
                            selectedIndex = 1
                            navController.navigate(ROUT_PRODUCT_LIST)
                        },
                        colors = itemColors
                    )

                    NavigationBarItem(
                        icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
                        label = { Text("Cart") },
                        selected = selectedIndex == 2,
                        onClick = {
                            selectedIndex = 2
                            navController.navigate(ROUT_CART) // If you add cart screen
                        },
                        colors = itemColors
                    )

                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                        label = { Text("Profile") },
                        selected = selectedIndex == 3,
                        onClick = {
                            selectedIndex = 3
                            navController.navigate(ROUT_PROFILE)
                        },
                        colors = itemColors
                    )
                }
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                ) {
                    Spacer(Modifier.height(10.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text("Search products...") },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        shape = RoundedCornerShape(18.dp),
                        singleLine = true
                    )

                    Spacer(Modifier.height(20.dp))

                    val pagerState = rememberPagerState(pageCount = { 3 })

                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(horizontal = 16.dp),
                        pageSpacing = 16.dp
                    ) { page ->
                        val imageRes = when (page) {
                            0 -> R.drawable.newsofa
                            1 -> R.drawable.bed1
                            2 -> R.drawable.chair1
                            else -> R.drawable.newsofa
                        }
                        Image(
                            painter = painterResource(id = imageRes),
                            contentDescription = "Carousel Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(16.dp))
                        )
                    }

                    Spacer(Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Categories", fontWeight = FontWeight.Bold)
                        Text("View all", color = Color.Gray)
                    }

                    Spacer(Modifier.height(10.dp))

                    Row(modifier = Modifier.padding(start = 20.dp)) {
                        listOf(
                            "Sofas" to ROUT_SOFAS,
                            "Beds" to ROUT_BEDS,
                            "Tables" to ROUT_TABLES,
                            "Chairs" to ROUT_CHAIRS
                        ).forEach { (title, route) ->
                            Card(
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(40.dp)
                                    .clickable { navController.navigate(route) }
                                    .padding(end = 10.dp),
                                elevation = CardDefaults.cardElevation(10.dp),
                                colors = CardDefaults.cardColors(Orange)
                            ) {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    Text(
                                        text = title,
                                        fontSize = 15.sp,
                                        color = Color.Black,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }

                    Spacer(Modifier.height(25.dp))

                    Card(
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(Orange),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Column(modifier = Modifier.padding(18.dp)) {
                            Text("Focus on the sofas!", fontWeight = FontWeight.Bold, color = Color.Red)
                            Spacer(Modifier.height(6.dp))
                            Text("Up to 30% off on selected sofas for a limited time")
                            Spacer(Modifier.height(6.dp))
                            Text("View more", fontWeight = FontWeight.Medium)
                        }
                    }

                    Spacer(Modifier.height(25.dp))

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Newly added products", fontWeight = FontWeight.Bold)
                        Text("View all", color = Color.Gray)
                    }

                    Spacer(Modifier.height(10.dp))

                    HorizontalScrollSection()
                }
            }
        )
    }
}

@Composable
fun HorizontalScrollSection() {
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
            .padding(start = 20.dp)
    ) {
        listOf(
            R.drawable.newsofa to "Ksh.12000",
            R.drawable.bed1 to "Ksh.17000",
            R.drawable.table1 to "Ksh.7500",
            R.drawable.chair1 to "Ksh.5350"
        ).forEach { (image, price) ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(end = 30.dp)
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(text = price, fontSize = 15.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
