package org.example.repository

import org.example.model.Language

import org.springframework.data.jpa.repository.JpaRepository

interface LanguageRepository : JpaRepository<Language, Long>
