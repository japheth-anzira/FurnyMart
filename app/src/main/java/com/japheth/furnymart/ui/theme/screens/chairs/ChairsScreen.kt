package com.japheth.furnymart.ui.theme.screens.chairs

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChairsScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()
        .padding(18.dp)) {

        val mContext = LocalContext.current

        TopAppBar(
            title = { Text("Chairs") },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back")
                }
            },
            actions ={
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search")
                }
            }
        )

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
                    modifier = Modifier.size(130.dp)
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
                    modifier = Modifier.size(120.dp)
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
                    modifier = Modifier.size(130.dp)
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



    }



}





@Preview(showBackground = true)
@Composable
fun ChairsScreenPreview(){
    ChairsScreen(navController= rememberNavController())
}

