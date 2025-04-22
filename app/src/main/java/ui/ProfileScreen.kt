package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ariawaludin.myapplication.R

@Composable
fun ProfileScreen(name: String) {
    val profileImage = when (name) {
        "Ari" -> R.drawable.profile_ari
        "Nani" -> R.drawable.ic_launcher_background
        "Budi" -> R.drawable.ic_launcher_background
        else -> R.drawable.ic_launcher_background
    }

    val phoneNumber = when (name) {
        "Ari" -> "+62 812 3456 7890"
        "Nani" -> "+62 813 9876 1234"
        "Budi" -> "+62 811 1111 2222"
        else -> "+62 800 0000 0000"
    }

    val lastSeen = when (name) {
        "Ari" -> "Last seen today at 14:32"
        "Nani" -> "Last seen yesterday"
        "Budi" -> "Online"
        else -> "Last seen a while ago"
    }

    val bio = when (name) {
        "Ari" -> "Just a simple guy who loves code and coffee ☕"
        "Nani" -> "Always smile 😊"
        "Budi" -> "Travel. Food. Repeat. 🌍🍜"
        else -> "No bio available"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Image
        Image(
            painter = painterResource(id = profileImage),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Name
        Text(text = name, fontSize = 24.sp, fontWeight = FontWeight.Bold)

        // Phone Number
        Text(text = phoneNumber, fontSize = 16.sp)

        // Last Seen
        Text(
            text = lastSeen,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Action Buttons (Message, Audio, Video)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextButton(onClick = { /* Handle Message Click */ }) {
                Text("Message")
            }
            TextButton(onClick = { /* Handle Audio Click */ }) {
                Text("Audio")
            }
            TextButton(onClick = { /* Handle Video Click */ }) {
                Text("Video")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Bio Section
        Column(modifier = Modifier.fillMaxWidth()) {
            Text("Bio", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = bio, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Media Section (Placeholder)
        Column(modifier = Modifier.fillMaxWidth()) {
            Text("Media", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Belum ada media.",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}
