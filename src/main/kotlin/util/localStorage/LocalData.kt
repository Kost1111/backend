package ru.local.util.localStorage

object LocalData {
    val data: MutableList<UserData> = mutableListOf()
}

data class UserData(val login: String, val token: String)