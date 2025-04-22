package ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun Tab3Screen(navController: NavController) {
    val data = (1..10).map { "Item Tab 2 ke-$it" }

    LazyColumn {
        items(data) { item ->
            Text(
                text = item,
                modifier = Modifier.padding(16.dp)
            )
        }
    }

}
