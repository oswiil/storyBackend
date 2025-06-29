package org.example.service

import org.example.DTO.UserDTO
import org.example.model.Language
import org.example.model.User
import org.example.model.Profile
import org.example.repository.UserRepository
import org.example.repository.ProfileRepository
import org.example.repository.LanguageRepository

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository, private val languageRepository: LanguageRepository, private val profileRepository: ProfileRepository) {

    fun getAll(): List<User> = userRepository.findAll()

    fun createUser(language: Language, profile: Profile): User = userRepository.save(User(language = language, profile = profile))
    fun createUserByDTO(userDTO: UserDTO): User {
        val language = languageRepository.findById(userDTO.languageId)
            .orElseThrow { IllegalArgumentException("Language not found") }

        val profile = profileRepository.findById(userDTO.profileId)
            .orElseThrow { IllegalArgumentException("Profile not found") }

        return createUser(language, profile)
    }

}
