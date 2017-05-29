package kotlin_spider.music163.domain

import org.springframework.data.repository.CrudRepository

/**
 * Created by nbsaw on 2017/5/29.
 */

interface Music163Repository : CrudRepository<Music163Entity, Long> {
    fun findBySinger(singer: Long): List<Music163Entity>
}