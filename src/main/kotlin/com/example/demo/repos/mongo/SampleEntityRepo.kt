package com.example.demo.repos.mongo

import com.example.demo.repos.mongo.entity.SampleEntity
import com.example.demo.repos.mongo.extra.SampleEntityRepoExtra
import org.springframework.data.mongodb.repository.MongoRepository

interface SampleEntityRepo: MongoRepository<SampleEntity, String>, SampleEntityRepoExtra {
}