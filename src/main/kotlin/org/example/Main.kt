package org.example
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StoryBackendApplication

fun main(args: Array<String>) {
    runApplication<StoryBackendApplication>(*args)
}
