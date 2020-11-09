package com.example.demo.repos.mongo.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document(SampleEntity.COLLECTION_NAME)
class SampleEntity {
        companion object {
                const val COLLECTION_NAME = "entity-test"
                const val ID = "_id"
                const val DATA = "data"
                const val CREATION_DATE = "creationDate"
                const val LAST_UPDATE_DATE = "lastUpdateDate"
        }

        @Id
        lateinit var id: String

        @Field(DATA)
        var value: String? = null

        @CreatedDate
        @Field(CREATION_DATE)
        lateinit var creationDate: Date

        @LastModifiedDate
        @Field(LAST_UPDATE_DATE)
        lateinit var lastUpdateDate: Date


}