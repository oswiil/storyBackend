package org.example.controller

import org.example.model.User
import org.example.service.UserService
import org.example.DTO.UserDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getUsers(): List<User> = userService.getAll()

    @PostMapping
    fun createUser(@RequestBody userDTO: UserDTO): ResponseEntity<User> {
        val createdUser = userService.createUserByDTO(userDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser)
    }
}






