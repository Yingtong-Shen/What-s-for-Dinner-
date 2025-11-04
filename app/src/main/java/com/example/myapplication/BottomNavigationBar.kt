import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    // Define the three pages in the bottom navigation bar (Home, Add, Settings)
    val items = listOf(
        Routes.Home,
        Routes.Add,
        Routes.Settings
    )

    val currentRoute = navController.currentBackStackEntry?.destination?.route

    // Create a bottom bar using Material3's NavigationBar
    NavigationBar {
        items.forEach { route ->
            NavigationBarItem(
                selected = false,
                onClick = {
                    if (currentRoute != route.route){
                        navController.navigate(route.route) {
                            launchSingleTop = true
                            popUpTo(Routes.Home.route)
                        }
                    }
                },
                icon = { Icon(Icons.Default.Home, contentDescription = null) },
                label = { Text(route.route) }
            )
        }
    }
}
