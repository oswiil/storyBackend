package org.example.repository

import org.springframework.data.jpa.repository.JpaRepository

import org.example.model.Profile
interface ProfileRepository : JpaRepository<Profile, Long>