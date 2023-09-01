package com.example.kmptest

import com.example.kmptest.managedEntities.ManagedAvatar
import com.example.kmptest.managedEntities.ManagedOwnedAvatar
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class RealmManager {
    companion object {
        private val config = RealmConfiguration.create(
            schema = setOf(
                ManagedAvatar::class,
                ManagedOwnedAvatar::class
            )
        )
        private val config2 = RealmConfiguration.Builder(
            setOf(
                ManagedAvatar::class,
                ManagedOwnedAvatar::class))
            .schemaVersion(68)
            .build()
        val shared = Realm.open(config2)
    }
}