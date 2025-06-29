package org.example.model

import jakarta.persistence.*

@Entity
@Table(name = "solution")
data class Solution(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "chapter_id", insertable = false, updatable = false)
    var chapterId: Long,

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    var chapter: Chapter,

    @Column(name = "solution_type_id", insertable = false, updatable = false)
    var solutionTypeId: Long,

    @ManyToOne
    @JoinColumn(name = "solution_type_id")
    var solutionType: SolutionType
)
