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
import androidx.navigation.NavController

@Composable
fun ChatPreviews(
    profileImage: Painter,
    name: String,
    message: String,
    time: String,
    isSender: Boolean, // Add this to differentiate between sender and receiver
    onChatClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onChatClick() },
        horizontalArrangement = if (isSender) Arrangement.End else Arrangement.Start, // Align chat bubble to left or right
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Image and Name at the top
        Column(
            horizontalAlignment = if (isSender) Alignment.End else Alignment.Start // Adjust profile alignment based on sender/receiver
        ) {
            Image(
                painter = profileImage,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .clickable { onProfileClick() }
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Chat Bubble
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
