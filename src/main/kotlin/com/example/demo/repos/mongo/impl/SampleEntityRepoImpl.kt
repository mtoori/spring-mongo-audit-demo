package com.example.demo.repos.mongo.impl

import com.example.demo.repos.mongo.entity.SampleEntity
import com.example.demo.repos.mongo.extra.SampleEntityRepoExtra
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update

class SampleEntityRepoImpl(
        private val mongoOperations: MongoOperations
): SampleEntityRepoExtra {
    override fun upsert(value: String): Boolean {
        return mongoOperations.upsert(Query().addCriteria(Criteria.where(SampleEntity.DATA).`is`(value)),
                Update().set(SampleEntity.DATA, value), SampleEntity::class.java).upsertedId == null
    }

    override fun update(value: String, newValue: String): Boolean {
        return mongoOperations.updateFirst(Query().addCriteria(Criteria.where(SampleEntity.DATA).`is`(value)),
                Update().set(SampleEntity.DATA, newValue), SampleEntity::class.java).modifiedCount > 0
    }
}