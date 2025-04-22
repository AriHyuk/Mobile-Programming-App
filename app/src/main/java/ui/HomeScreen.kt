package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(navController: NavController) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabItems = listOf("Chat", "Broadcast", "Update")

    Column(modifier = Modifier.fillMaxSize()) {

        // Tambahkan judul di atas tab
        Text(
            text = "WangS App",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 8.dp)
                .align(Alignment.CenterHorizontally)
        )

        // Tab bar
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabItems.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }

        // Konten sesuai tab
        when (selectedTabIndex) {
            0 -> Tab1Screen(navController)
            1 -> Tab2Screen(navController)
            2 -> Tab3Screen(navController)
        }
    }
}



