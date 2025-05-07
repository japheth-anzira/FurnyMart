package com.japheth.furnymart.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.japheth.furnymart.data.UserDatabase
import com.japheth.furnymart.repository.UserRepository
import com.japheth.furnymart.ui.screens.auth.LoginScreen
import com.japheth.furnymart.ui.screens.auth.RegisterScreen
import com.japheth.furnymart.ui.screens.cart.CartScreen
import com.japheth.furnymart.ui.screens.checkout.CheckoutScreen
import com.japheth.furnymart.ui.screens.profile.ProfileScreen
import com.japheth.furnymart.ui.theme.screens.about.AboutScreen
import com.japheth.furnymart.ui.theme.screens.beds.BedsScreen
import com.japheth.furnymart.ui.theme.screens.chairs.ChairsScreen
import com.japheth.furnymart.ui.theme.screens.home.HomeScreen
import com.japheth.furnymart.ui.theme.screens.orderconfirmation.OrderConfirmationScreen
import com.japheth.furnymart.ui.theme.screens.sofa.SofaScreen
import com.japheth.furnymart.ui.theme.screens.splash.OnBoardScreen
import com.japheth.furnymart.ui.theme.screens.splash.OnBoardScreen2
import com.japheth.furnymart.ui.theme.screens.splash.SplashScreen
import com.japheth.furnymart.ui.theme.screens.tables.TablesScreen
import com.japheth.furnymart.viewmodel.AuthViewModel
import com.japheth.furnymart.viewmodel.ProductViewModel


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH,
    productViewModel: ProductViewModel = viewModel(),
) {
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_BEDS) {
            BedsScreen(navController)
        }
        composable(ROUT_CHAIRS) {
            ChairsScreen(navController)
        }
        composable(ROUT_SOFAS) {
            SofaScreen(navController)
        }
        composable(ROUT_CART) {
            CartScreen(navController)
        }
        composable(ROUT_CHECKOUT) {
          CheckoutScreen(navController)
        }
        composable(ROUT_TABLES) {
            TablesScreen(navController)
        }
        composable(
            route = "$ROUT_PROFILE/{name}/{email}/{phone}/{address}/{username}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType },
                navArgument("phone") { type = NavType.StringType },
                navArgument("address") { type = NavType.StringType },
                navArgument("username") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val email = backStackEntry.arguments?.getString("email") ?: ""
            val phone = backStackEntry.arguments?.getString("phone") ?: ""
            val address = backStackEntry.arguments?.getString("address") ?: ""
            val username = backStackEntry.arguments?.getString("username") ?: ""

            ProfileScreen(
                navController = navController,
                name = name,
                email = email,
               phone = phone,
                address = address,
                username = username)
        }

        composable(ROUT_ONBOARDSCREEN) {
            OnBoardScreen(navController)
        }
        composable(ROUT_ONBOARDSCREEN2) {
            OnBoardScreen2(navController)
        }






        //AUTHENTICATION

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }









    }
}