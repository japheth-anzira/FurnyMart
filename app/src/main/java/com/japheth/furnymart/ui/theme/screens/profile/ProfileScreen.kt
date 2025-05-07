package com.japheth.furnymart.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.japheth.furnymart.R
import com.japheth.furnymart.ui.theme.Orange

@Composable
fun ProfileScreen(
    navController: NavController,
    name: String,
    email: String,
    phone: String,
    address: String,
    username: String
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Top background gradient
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(Color.Red, Orange)
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }

            // Profile Picture
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                painter = painterResource(R.drawable.person1),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Username and email
            Text("@$username", color = Color.White, fontSize = 20.sp)
            Text(email, color = Color.White.copy(alpha = 0.9f), fontSize = 14.sp)

            Spacer(modifier = Modifier.height(30.dp))
            Text("Account Info", fontSize = 22.sp, color = Color.Black)

            Spacer(modifier = Modifier.height(16.dp))

            // Info cards
            ProfileInfoCard(R.drawable.name, "Name", name)
            ProfileInfoCard(R.drawable.contact1, "Mobile", phone)
            ProfileInfoCard(R.drawable.email1, "Email", email)
            ProfileInfoCard(R.drawable.address1, "Address", address)
        }
    }
}

@Composable
fun ProfileInfoCard(iconRes: Int, label: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(iconRes),
                contentDescription = label,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text("$label:", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(8.dp))
            Text(value)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    ProfileScreen(
        navController = navController,
        name = "Omar Hussein",
        email = "omarhussein@gmail.com",
        phone = "0724568990",
        address = "Mbagathi - 1756.107",
        username = "OmarHussein"
    )
}
