package com.example.kmptest.datamanagers

import com.example.kmptest.entities.Avatar
import com.example.kmptest.remoteEntities.AvatarRemote
import com.example.kmptest.managedEntities.ManagedAvatar
import com.example.kmptest.RealmManager
import com.example.kmptest.remoteEntities.toRealmObject
import io.realm.kotlin.ext.query

interface DataManager<T> {
    fun save(json: String): List<T>
    fun fetchAll(): List<T>
}

class SharedAvatarDataManager: DataManager<Avatar> {
    override fun save(json: String): List<Avatar> {
        val remoteList: List<AvatarRemote> = AvatarRemote.fromJsonString(json)
        val managedList: List<ManagedAvatar> = remoteList.map {
            it.toRealmObject()
        }

        return RealmManager.shared.writeBlocking {
            delete(this.query<ManagedAvatar>().find())
            return@writeBlocking managedList.map {
                copyToRealm(it)
                return@map it.convertToEntity()
            }
        }
    }

    override fun fetchAll(): List<Avatar> {
        return RealmManager.shared.query<ManagedAvatar>().find().toList().map{ it.convertToEntity() }
    }
}