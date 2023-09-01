package com.example.kmptest.remoteEntities

import com.example.kmptest.managedEntities.ManagedAvatar
import com.example.kmptest.managedEntities.ManagedOwnedAvatar
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class AvatarRemote(
    var id: Int = 0,
    var url: String = "",
    var type: Int = 0,

    var owned: OwnedAvatarRemote? = null
) {
    companion object {
        fun fromJsonString(json: String): List<AvatarRemote> {
            return Json.decodeFromString<List<AvatarRemote>>(json)
        }
    }
}

fun AvatarRemote.toRealmObject(): ManagedAvatar {
    return ManagedAvatar().apply {
        id = this@toRealmObject.id
        url = this@toRealmObject.url
        type = this@toRealmObject.type
        owned = this@toRealmObject.owned?.toRealmObject()
    }
}

@Serializable
data class OwnedAvatarRemote(
    var avatarId: Int = 0,
    var avatarType: Int = 0
)

fun OwnedAvatarRemote.toRealmObject(): ManagedOwnedAvatar {
    return ManagedOwnedAvatar().apply {
        avatarId = this@toRealmObject.avatarId
        avatarType = this@toRealmObject.avatarType
    }
}