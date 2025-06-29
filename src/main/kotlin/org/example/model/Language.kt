package org.example.model

import jakarta.persistence.*

@Entity
data class Language(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String
)
