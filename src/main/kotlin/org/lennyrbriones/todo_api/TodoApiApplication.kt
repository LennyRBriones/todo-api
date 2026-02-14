package org.lennyrbriones.todo_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class TodoApiApplication

fun main(args: Array<String>) {
    runApplication<TodoApiApplication>(*args)
}

@RestController
class HealthController {

    @GetMapping("/")
    fun root(): Map<String, String> = mapOf(
        "message" to "Todo API up"
    )

    @GetMapping("/health")
    fun health(): Map<String, String> = mapOf(
        "status" to "ok"
    )
}
