package kotlin_spider.music163.web

import com.nbsaw.kotlin_spider.music163.Music163Spider
import kotlin_spider.music163.domain.Music163Entity
import kotlin_spider.music163.domain.Music163Repository
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.websocket.server.PathParam

/**
 * Created by nbsaw on 2017/5/29.
 */

@RestController
@RequestMapping(value = "/163")
class Music163Controller(val repository:Music163Repository) {
    @GetMapping
    fun get(name:String): LinkedList<Any> {
        println(name)
//        repository.findBySinger(id)
        return  Music163Spider(name).descList
    }
}