package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.res.painterResource // Make sure to add this import
import com.ariawaludin.myapplication.R


// Data class for Pesan
data class Pesan(
    val profileImage: Int = R.drawable.ic_launcher_background, // Default image for simplicity
    val name: String,
    val message: String,
    val time: String,
    val isSender: Boolean
)

@Composable
fun ChatDetailScreen(name: String) {
    val chatList = listOf(
        Pesan(profileImage = R.drawable.profile_ari, name = "Ari", message = "Hai!", time = "12:09", isSender = true),
        Pesan(profileImage = R.drawable.profile_ari, name = "Nani", message = "Halo $name!", time = "12:10", isSender = false),
        Pesan(profileImage = R.drawable.profile_ari, name = "Ari", message = "Gimana kabarnya?", time = "12:12", isSender = true),
        Pesan(profileImage = R.drawable.profile_ari, name = "Nani", message = "Alhamdulillah baik, kamu gimana?", time = "12:13", isSender = false),
        Pesan(profileImage = R.drawable.profile_ari, name = "Ari", message = "Aku juga baik, makasih ya!", time = "12:14", isSender = true)
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        // Profile and Name on top
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = chatList.first().profileImage),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Pesan Messages List
        LazyColumn {
            items(chatList.size) { index ->
                val Pesan = chatList[index]
                ChatPreviewss(
                    message = Pesan.message,
                    time = Pesan.time,
                    isSender = Pesan.isSender
                )
            }
        }
    }
}

@Composable
fun ChatPreviewss(
    message: String,
    time: String,
    isSender: Boolean,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = if (isSender) Arrangement.End else Arrangement.Start, // Align message left or right based on isSender
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Pesan Bubble
        Column(
            horizontalAlignment = if (isSender) Alignment.End else Alignment.Start
        ) {
            // Message Bubble
            Box(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .background(
                        color = if (isSender) Color(0xFFADD8E6) else Color.LightGray, // Light Blue for sender, Light Gray for receiver
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(12.dp)
            ) {
                Text(
                    text = message,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            // Time
            Text(
                text = time,
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
