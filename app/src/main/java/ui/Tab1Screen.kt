package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ariawaludin.myapplication.R


data class Chat(
    val profileImage: Int,
    val name: String,
    val message: String,
    val time: String,
    val isSender: Boolean
)

@Composable
fun Tab1Screen(navController: NavController) {
    val chatList = listOf(
        Chat(R.drawable.profile_ari, "Ari", "ysdh", "12:09", isSender = true),
        Chat(R.drawable.ic_launcher_background, "Nani", "ysdh makasih", "12:07", isSender = true),
        Chat(R.drawable.ic_launcher_background, "Budi", "oke siap", "12:01", isSender = true)
    )

    LazyColumn {
        items(chatList.size) { index ->
            val chat = chatList[index]
            ChatPreview(
                profileImage = painterResource(id = chat.profileImage),
                name = chat.name,
                message = chat.message,
                time = chat.time,
                isSender = chat.isSender,
                onChatClick = { navController.navigate("chat_detail/${chat.name}") },
                onProfileClick = { navController.navigate("profile/${chat.name}") }
            )
        }
    }
}
@Composable
fun ChatPreview(
    profileImage: Painter,
    name: String,
    message: String,
    time: String,
    isSender: Boolean,
    onChatClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onChatClick() }
            .padding(8.dp)
    ) {
        Image(
            painter = profileImage,
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .clickable { onProfileClick() }
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier = Modifier.weight(1f)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = name, fontWeight = FontWeight.Bold)
                Text(text = time, fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.DoneAll,
                    contentDescription = "Read Status",
                    modifier = Modifier.size(16.dp),
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = message, color = Color.Gray)
            }
        }
    }
}


