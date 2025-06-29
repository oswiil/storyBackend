package org.example.model

import jakarta.persistence.*

@Entity
@Table(name = "solution_type")
data class SolutionType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var name: String,

    @OneToMany(mappedBy = "solutionType")
    var solutions: MutableList<Solution> = mutableListOf()
)