package org.example.model


import jakarta.persistence.*

@Entity
data class Level(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val numberChapter: Int,

    @ManyToOne
    @JoinColumn(name = "story_id")
    val story: Story
)
