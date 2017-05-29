package kotlin_spider.music163.web

import kotlin_spider.music163.domain.Music163Entity
import kotlin_spider.music163.domain.Music163Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

/**
 * Created by nbsaw on 2017/5/29.
 */

@RestController
@RequestMapping(value = "/163")
class Music163Control(val repository:Music163Repository) {
    @GetMapping
    fun get(@PathParam("id") id:Long): List<Music163Entity> {
        return repository.findBySinger(id)
    }
}