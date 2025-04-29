package com.japheth.furnymart.ui.theme.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import com.japheth.furnymart.R


@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("login") }

    Box(
        modifier = Modifier.fillMaxSize().background(Color.Unspecified),
        contentAlignment = Alignment.Center){

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.sofa),
                contentDescription = "img",
                modifier = Modifier.size(100.dp)
            )
            Spacer(Modifier.height(18.dp))
            Text("FurnyMart",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue)
            Text("Shop with us",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue)
            Spacer(Modifier.height(20.dp))
            Image(
                painter = painterResource(R.drawable.shop),
                contentDescription = "img",
                modifier = Modifier.size(100.dp)
            )






        }
    }




}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    SplashScreen(navController= rememberNavController())
}




















