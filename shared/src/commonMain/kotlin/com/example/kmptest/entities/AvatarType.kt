package com.example.kmptest.entities

enum class AvatarType {
    user,
    crew;

    companion object {
        fun fromInt(value: Int): AvatarType {
            return when (value) {
                0 -> user
                1 -> crew
                else -> {
                    user
                }
            }
        }

    }
}