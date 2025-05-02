package com.japheth.furnymart.ui.theme.screens.contact

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.japheth.furnymart.navigation.ROUT_HOME


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val mContext = LocalContext.current

        //Scaffold

        var selectedIndex by remember { mutableStateOf(0) }

        Scaffold(
            //TopBar
            topBar = {
                TopAppBar(
                    title = { Text("FurnyMart") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Gray,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    actions = {
                        IconButton(
                            onClick = {}) {
                            Icon(
                                Icons.Default.ShoppingCart,
                                contentDescription = "Cart"
                            )
                        }
                    }
                )
            },

            //BottomBar
            bottomBar = {
                NavigationBar(
                    containerColor = Color.Gray
                ) {
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                        label = { Text("Home") },
                        selected = selectedIndex == 0,
                        onClick = {
                            selectedIndex = 0
                            navController.navigate(ROUT_HOME)
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.CheckCircle, contentDescription = "Favorites") },
                        label = { Text("Products") },
                        selected = selectedIndex == 1,
                        onClick = {
                            selectedIndex = 1
                            // navController.navigate(ROUT_HOME)
                        }
                    )

                    NavigationBarItem(
                        icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Home") },
                        label = { Text("Cart") },
                        selected = selectedIndex == 0,
                        onClick = {
                            selectedIndex = 0
                            navController.navigate(ROUT_HOME)
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                        label = { Text("Profile") },
                        selected = selectedIndex == 2,
                        onClick = {
                            selectedIndex = 2
                            //  navController.navigate(ROUT_HOME)
                        }
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
                        leadingIcon = {
                            Icon(Icons.Default.Search, contentDescription = null)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(18.dp),
                        singleLine = true
                    )

                    Spacer(Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Catergories", fontWeight = FontWeight.Bold)
                        Text("View all", color = Color.Gray)
                    }




                    Spacer(Modifier.height(10.dp))


                    Row(modifier = Modifier.padding(start = 20.dp)) {

                        //Card
                        Card(
                            modifier = Modifier.width(50.dp).height(30.dp),
                            elevation = CardDefaults.cardElevation(10.dp),
                            colors = CardDefaults.cardColors(Color.LightGray)
                        ) {

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {

                                Text(
                                    text = "Sofas",
                                    fontSize = 15.sp,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center
                                )

                            }

                        }
                        //End of card

                        Spacer(modifier = Modifier.width(20.dp))

                        //Card
                        Card(
                            modifier = Modifier.width(50.dp).height(30.dp),
                            elevation = CardDefaults.cardElevation(10.dp),
                            colors = CardDefaults.cardColors(Color.LightGray)
                        ) {

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Beds",
                                    fontSize = 15.sp,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center
                                )

                            }

                        }
                        //End of card

                        Spacer(modifier = Modifier.width(20.dp))

                        //Card
                        Card(
                            modifier = Modifier.width(50.dp).height(30.dp),
                            elevation = CardDefaults.cardElevation(10.dp),
                            colors = CardDefaults.cardColors(Color.LightGray),


                            ) {

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Tables",
                                    fontSize = 15.sp,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center
                                )

                            }

                        }
                        //End of card

                        Spacer(modifier = Modifier.width(20.dp))

                        //Card
                        Card(
                            modifier = Modifier.width(50.dp).height(30.dp),
                            elevation = CardDefaults.cardElevation(10.dp),
                            colors = CardDefaults.cardColors(Color.LightGray)
                        ) {

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Chairs",
                                    fontSize = 15.sp,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center
                                )

                            }

                        }
                        //End of card

                    }
                    //End of row


                    Spacer(Modifier.height(25.dp))

                    Card(
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(Color.LightGray),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(18.dp)) {
                            Text(
                                "Focus on the the sofas!", fontWeight = FontWeight.Bold,
                                color = Color.Red
                            )
                            Spacer(Modifier.height(6.dp))
                            Text("Upto 30% off on selected sofas for limited")
                            Spacer(Modifier.height(6.dp))
                            Text("view more", fontWeight = FontWeight.Medium)

                        }
                    }

                    Spacer(Modifier.height(25.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Newly added products", fontWeight = FontWeight.Bold)
                        Text("View all", color = Color.Gray)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    //Row
                    Row(
                        modifier = Modifier.padding(start = 20.dp).horizontalScroll(
                            rememberScrollState()
                        )
                    ) {

                        //Column
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            //Image
                            Image(
                                painter = painterResource(R.drawable.newsofa),
                                contentDescription = "img",
                                modifier = Modifier.size(120.dp)
                                    .clip(shape = RoundedCornerShape(7.dp)),
                                contentScale = ContentScale.FillBounds
                            )
                            //end of image



                            Text(
                                text = "Ksh.12000",
                                fontSize = 15.sp
                            )

                            //Button
                            Button(
                                onClick = {
                                    val simToolKitLaunchIntent =
                                        mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                    simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(Color.Unspecified)
                            ) {
                                Text(text = "Pay")
                            }
                            //End of button

                        }
                        //End of Column

                        Spacer(modifier = Modifier.width(70.dp))

                        //Column
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            //Image
                            Image(
                                painter = painterResource(R.drawable.bed1),
                                contentDescription = "img",
                                modifier = Modifier.size(130.dp)
                                    .clip(shape = RoundedCornerShape(10.dp)),
                                contentScale = ContentScale.FillBounds
                            )
                            //end of image


                            Text(
                                text = "Ksh.17000",
                                fontSize = 15.sp
                            )

                            //Button
                            Button(
                                onClick = {
                                    val simToolKitLaunchIntent =
                                        mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                    simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                                },
                                shape = RoundedCornerShape(7.dp),
                                colors = ButtonDefaults.buttonColors(Color.Unspecified)
                            ) {
                                Text(text = "Pay")
                            }
                            //End of button
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    //Row
                    Row(
                        modifier = Modifier.padding(start = 20.dp).horizontalScroll(
                            rememberScrollState()
                        )
                    ) {

                        //Column
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            //Image
                            Image(
                                painter = painterResource(R.drawable.table1),
                                contentDescription = "img",
                                modifier = Modifier.size(105.dp)
                                    .clip(shape = RoundedCornerShape(7.dp)),
                                contentScale = ContentScale.FillBounds
                            )
                            //end of image

                            Text(
                                text = "Ksh.7500",
                                fontSize = 15.sp
                            )

                            //Button
                            Button(
                                onClick = {
                                    val simToolKitLaunchIntent =
                                        mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                    simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(Color.Unspecified)
                            ) {
                                Text(text = "Pay")
                            }
                            //End of button

                        }
                        //End of Column

                        Spacer(modifier = Modifier.width(100.dp))

                        //Column
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            //Image
                            Image(
                                painter = painterResource(R.drawable.chair1),
                                contentDescription = "img",
                                modifier = Modifier.size(120.dp)
                                    .clip(shape = RoundedCornerShape(7.dp)),
                                contentScale = ContentScale.FillBounds
                            )
                            //end of image



                            Text(
                                text = "Ksh.5350",
                                fontSize = 15.sp
                            )

                            //Button
                            Button(
                                onClick = {
                                    val simToolKitLaunchIntent =
                                        mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                    simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(Color.Unspecified)
                            ) {
                                Text(text = "Pay")
                            }
                            //End of button
                        }
                    }


                    //End of scaffold

                }


            },
        )
    }
}
@Preview(showBackground = true)
@Composable
fun ContactScreenPreview(){
    ContactScreen(navController= rememberNavController())
}