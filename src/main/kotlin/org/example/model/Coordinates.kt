package org.example.model

import jakarta.persistence.*

@Entity
@Table(name = "coordinates")
data class Coordinates(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var x: Double,
    var y: Double,
    var z: Double,

    @OneToMany(mappedBy = "coordinates")
    var assets: MutableList<Asset> = mutableListOf()
)