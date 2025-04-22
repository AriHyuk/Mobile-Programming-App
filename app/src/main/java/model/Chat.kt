package model

data class Chat(
    val id: Int,
    val profileImage: Int,
    val name: String,
    val message: String,
    val time: String,
    val isSender: Boolean
)
