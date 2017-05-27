package org.jetbrains.kotlin.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class GreetingController {
    @RequestMapping("/")
    fun greeting(): String{
        return "一个不愿意透露姓名的网友上来就是操你妈逼"
    }
}

@SpringBootApplication
open class Application {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }
}