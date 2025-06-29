package org.example.model

import jakarta.persistence.*

@Entity
data class Progress(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne
    @JoinColumn(name = "story_id")
    val story: Story,

    @ManyToOne
    @JoinColumn(name = "level_id")
    val level: Level
)
