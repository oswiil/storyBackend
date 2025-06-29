package org.example.service


import org.example.model.Language
import org.example.model.Profile
import org.example.repository.ProfileRepository
import org.springframework.stereotype.Service
import org.example.DTO.ProfileDTO
// Servicios
@Service
class ProfileService(
    private val profileRepository: ProfileRepository
) {
    fun createProfile(profileDTO: ProfileDTO): ProfileDTO {
        val profile = profileDTO.toEntity()
        val savedProfile = profileRepository.save(profile)
        return savedProfile.toDTO()
    }

    fun ProfileDTO.toEntity(): Profile {
        return Profile(plan = this.plan)
    }

    fun Profile.toDTO(): ProfileDTO {
        return ProfileDTO(plan = this.plan)
    }
}