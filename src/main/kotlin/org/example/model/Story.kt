package org.example.model

import jakarta.persistence.*

@Entity
@Table(name = "story")
data class Story(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var name: String,

    @OneToMany(mappedBy = "story")
    var levels: MutableList<Level> = mutableListOf(),

    @OneToMany(mappedBy = "story")
    var chapters: MutableList<Chapter> = mutableListOf()
)