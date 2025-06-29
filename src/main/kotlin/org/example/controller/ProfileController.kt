package org.example.controller
import org.example.model.User
import org.example.service.ProfileService
import org.example.DTO.ProfileDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

// Controladores
@RestController
@RequestMapping("/api/profiles")
class ProfileController(
    private val profileService: ProfileService
) {
    @PostMapping
    fun createProfile(@RequestBody profile: ProfileDTO): ResponseEntity<ProfileDTO> {
        val createdProfile = profileService.createProfile(profile)
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(createdProfile)
    }
}