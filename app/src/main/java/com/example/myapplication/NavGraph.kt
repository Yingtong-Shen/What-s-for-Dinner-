import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun AppNavGraph(navController: NavHostController, viewModel: RecipeViewModel) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {
        composable(Routes.Home.route) {
            HomeScreen(navController, viewModel)
        }

        composable(Routes.Add.route) {
            AddRecipeScreen(navController, viewModel)
        }

        composable(Routes.Settings.route) {
            SettingsScreen(navController)
        }

        composable(
            route = Routes.Detail.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            DetailScreen(navController, viewModel, id)
        }

    }

}
