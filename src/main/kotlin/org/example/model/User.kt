package org.example.model

import jakarta.persistence.*

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "language_id")
    val language: Language,

    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL])
    val progress: Progress? = null
)
