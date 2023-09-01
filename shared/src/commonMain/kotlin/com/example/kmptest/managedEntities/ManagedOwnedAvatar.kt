package com.example.kmptest.managedEntities

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

class ManagedOwnedAvatar() : RealmObject {
    @PrimaryKey
    var avatarId: Int = 0
    var avatarType: Int = 0

    constructor(avatarId: Int = 0) : this() {
        this.avatarId = avatarId
    }
}