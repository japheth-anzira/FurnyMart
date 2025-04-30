package com.japheth.furnymart.ui.theme.screens.sofa

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.japheth.furnymart.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SofaScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()
        .padding(18.dp)) {
        TopAppBar(
            title = { Text("Sofas") },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.ArrowBack,
                        contentDescription = "Back")
                }
            },
            actions ={
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Search,
                        contentDescription = "Search")
                }
            }
        )

        Spacer(modifier = Modifier.height(10.dp))


        //Row
        Row(modifier = Modifier.padding(start = 5.dp)) {

            Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {
                    Image(
                        painter = painterResource(R.drawable.sofa1),
                        contentDescription = "img",
                        modifier = Modifier.size(100.dp)
                    )

                    Text(
                        text = "Sofa1",
                        fontSize = 20.sp,
                        color = Color.Black
                    )

                }

            }
            //End of card

            Spacer(modifier = Modifier.width(20.dp))



           Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {

                    Image(
                        painter = painterResource(R.drawable.sofa2),
                        contentDescription = "img",
                        modifier = Modifier.size(100.dp)
                    )

                    Text(
                        text = "Sofa2",
                        fontSize = 20.sp,
                        color = Color.Black
                    )

                }

            }
            //End of card

        }
        //End of row









@Preview(showBackground = true)
@Composable
fun SofaScreenPreview(){
    SofaScreen(navController= rememberNavController())
}