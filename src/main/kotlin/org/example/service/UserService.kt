package org.example.service

import org.example.model.Language
import org.example.model.User
import org.example.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAll(): List<User> = userRepository.findAll()

    fun createUser(language: Language): User = userRepository.save(User(language = language))
}
