package com.example.demo.repos.mongo.extra

interface SampleEntityRepoExtra{

    fun upsert(value: String): Boolean
    fun update(value: String, newValue: String): Boolean

}