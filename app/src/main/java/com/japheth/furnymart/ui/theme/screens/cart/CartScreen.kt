package com.japheth.furnymart.ui.screens.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.japheth.furnymart.viewmodel.CartViewModel
import com.japheth.furnymart.model.CartItem
import com.japheth.furnymart.ui.theme.screens.sofa.SofaScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavController, cartViewModel: CartViewModel = viewModel()) {
   val cartItems = cartViewModel.cartItems.value
   val total = cartViewModel.getTotalPrice()

   Scaffold(
      topBar = {
         TopAppBar(
            title = { Text("Your Cart") },
            navigationIcon = {
               IconButton(onClick = { navController.navigateUp() }) {
                  Icon(Icons.Default.ArrowBack, contentDescription = "Back")
               }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF6200EE))
         )
      },
      bottomBar = {
         BottomAppBar(containerColor = Color(0xFF6200EE)) {
            Row(
               modifier = Modifier
                  .fillMaxWidth()
                  .padding(16.dp),
               horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.CenterVertically
            ) {
               Text("Total: Ksh. %.2f".format(total), color = Color.White, fontSize = 18.sp)
               Button(onClick = { navController.navigate("checkout")
               }) {
                  Text("Checkout")
               }
            }
         }
      },
      content = { padding ->
         if (cartItems.isEmpty()) {
            Box(
               modifier = Modifier
                  .fillMaxSize()
                  .padding(padding),
               contentAlignment = Alignment.Center
            ) {
               Text("Your cart is empty.")
            }
         } else {
            LazyColumn(
               modifier = Modifier
                  .padding(padding)
                  .padding(16.dp)
            ) {
               items(cartItems) { cartItem ->
                  CartItemCard(cartItem = cartItem, cartViewModel = cartViewModel)
                  Spacer(modifier = Modifier.height(12.dp))
               }
            }
         }
      }
   )
}

@Composable
fun CartItemCard(cartItem: CartItem, cartViewModel: CartViewModel) {
   Card(
      modifier = Modifier.fillMaxWidth(),
      shape = RoundedCornerShape(12.dp),
      elevation = CardDefaults.cardElevation(4.dp)
   ) {
      Row(
         modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
         verticalAlignment = Alignment.CenterVertically
      ) {
         Image(
            painter = painterResource(id = cartItem.product.imagePath.toInt()),
            contentDescription = cartItem.product.name,
            modifier = Modifier
               .size(80.dp)
               .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
         )

         Spacer(modifier = Modifier.width(16.dp))

         Column(modifier = Modifier.weight(1f)) {
            Text(text = cartItem.product.name, fontSize = 18.sp)
            Text(
               text = "Ksh. %.2f x ${cartItem.quantity}".format(cartItem.product.price),
               fontSize = 14.sp,
               color = Color.Gray
            )
            Text(
               text = "Subtotal: Ksh. %.2f".format(cartItem.product.price * cartItem.quantity),
               fontSize = 14.sp
            )
         }

         IconButton(
            onClick = { cartViewModel.removeFromCart(cartItem.product) }
         ) {
            Icon(Icons.Default.Delete, contentDescription = "Remove item")
         }
      }
   }
}
@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
   CartScreen(navController = rememberNavController())
}