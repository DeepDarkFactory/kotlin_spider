package kotlin_spider.music163.web

import kotlin_spider.music163.domain.Music163Entity
import kotlin_spider.music163.domain.Music163Repository
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

/**
 * Created by nbsaw on 2017/5/29.
 */

@RestController
@RequestMapping(value = "/163")
class Music163Control(val repository:Music163Repository) {
    @GetMapping
    fun get(): String {
        println("wwwwwww")
//        repository.findBySinger(id)
        return "wwww"
    }

    @GetMapping("/post")
    fun post():String{
        println("asd")
        return "asd"
    }
}