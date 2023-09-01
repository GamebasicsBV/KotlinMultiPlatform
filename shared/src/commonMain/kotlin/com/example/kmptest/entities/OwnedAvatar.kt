package com.example.kmptest.entities

import com.example.kmptest.entities.AvatarType

data class OwnedAvatar(
    var avatarId: Int = 0,
    var avatarType: AvatarType = AvatarType.user
)