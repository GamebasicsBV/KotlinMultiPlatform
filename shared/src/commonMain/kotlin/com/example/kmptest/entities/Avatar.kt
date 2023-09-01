package com.example.kmptest.entities

data class Avatar(
    var id: Int = 0,
    var url: String = "",
    var type: AvatarType = AvatarType.user,

    var owned: OwnedAvatar? = null,
)