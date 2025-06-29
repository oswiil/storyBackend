package org.example.controller

import org.example.model.User
import org.example.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getUsers(): List<User> = userService.getAll()
}
