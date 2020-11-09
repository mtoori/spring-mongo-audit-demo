package com.example.demo.service

import com.example.demo.repos.mongo.entity.SampleEntity
import com.example.demo.repos.mongo.SampleEntityRepo
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class EntityService(private val sampleEntityRepo: SampleEntityRepo) {

    @PostConstruct
    fun init() {
        clear()
        create()
        createAndUpdate()
        findAndUpdate()
        upsert()
        nativeUpdate()
    }

    fun clear() {
        sampleEntityRepo.deleteAll()
    }

    fun create() {
        val entity = SampleEntity().also { it.value = "create" }
        sampleEntityRepo.save(entity)
    }

    fun createAndUpdate() {
        val entity = SampleEntity().also { it.value = "create" }
        sampleEntityRepo.save(entity)
        Thread.sleep(1000)
        entity.value = "createAndUpdate"
        sampleEntityRepo.save(entity)
    }

    fun findAndUpdate() {
        val id = sampleEntityRepo.save(SampleEntity().also { it.value = "find" }).id
        Thread.sleep(1000)
        val entity = sampleEntityRepo.findById(id).orElse(null)!!
        entity.value = "findAndUpdate"
        sampleEntityRepo.save(entity)
    }

    fun upsert() {
        sampleEntityRepo.upsert("upsert")

        sampleEntityRepo.upsert("upsertAgain")
        Thread.sleep(1000)
        sampleEntityRepo.upsert("upsertAgain")
    }

    fun nativeUpdate() {
        sampleEntityRepo.save(SampleEntity().also { it.value = "native" })
        Thread.sleep(1000)
        sampleEntityRepo.update("native","nativeUpdate")
    }

}