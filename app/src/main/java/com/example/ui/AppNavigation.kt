package com.example.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    viewModel: CropViewModel,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable("home") {
            HomeScreen(
                viewModel = viewModel,
                onCropClick = { cropId ->
                    navController.navigate("detail/$cropId")
                },
                onTrackerClick = {
                    navController.navigate("tracker")
                }
            )
        }
        composable(
            "detail/{cropId}",
            arguments = listOf(navArgument("cropId") { type = NavType.StringType })
        ) { backStackEntry ->
            val cropId = backStackEntry.arguments?.getString("cropId")
            DetailScreen(
                cropId = cropId,
                viewModel = viewModel,
                onBackClick = { navController.navigateUp() }
            )
        }
        composable("tracker") {
            TrackerScreen(
                viewModel = viewModel,
                onBackClick = { navController.navigateUp() }
            )
        }
    }
}
