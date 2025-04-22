package Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ui.ChatDetailScreen
import ui.HomeScreen
import ui.ProfileScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("chat_detail/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            ChatDetailScreen(name)
        }
        composable("profile/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            ProfileScreen(name)
        }
    }
}
