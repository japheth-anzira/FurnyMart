package com.japheth.furnymart.ui.theme.screens.splash


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.computeHorizontalBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.japheth.furnymart.R


@Composable
fun OnBoardScreen2(navController: NavController){
    navController.navigate("")
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween) {
        Spacer(Modifier.height(18.dp))

        Image(
            painter = painterResource(id = R.drawable.seat2),
            contentDescription = "Seat",
            modifier = Modifier
                .height(240.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Fit)

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            repeat(3){
                Box(
                    modifier = Modifier
                        .size(if (it==0) 26.dp else 22.dp)
                        .padding(5.dp)
                        .clip(CircleShape)
                        .background(if (it==0) Color.Red else Color.Gray)
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = "Polyester Fibres",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp)

            Spacer(Modifier.height(10.dp))

            Text(
                text = " The strength,durable and easy to clean material for your furniture that resists wrinkles,fading and stains ",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color= Color.Black)
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Gray),
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Skip", color = Color.White)
        }






    }



}

@Preview(showBackground = true)
@Composable
fun OnBoardScreen2Preview(){
    OnBoardScreen2(navController= rememberNavController())
}