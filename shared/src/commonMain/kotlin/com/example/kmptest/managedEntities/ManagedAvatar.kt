package com.example.kmptest.managedEntities

import com.example.kmptest.entities.Avatar
import com.example.kmptest.entities.AvatarType
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class ManagedAvatar() : RealmObject {
    @PrimaryKey
    var id: Int = 0
    var type: Int = 0
    var url: String = ""

    var owned: ManagedOwnedAvatar? = null

    constructor(id: Int = 0) : this() {
        this.id = id
    }

    fun convertToEntity(): Avatar {
        return Avatar(
            id,
            url,
            AvatarType.fromInt(type),
        )
    }
}