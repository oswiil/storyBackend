package org.example.model

import jakarta.persistence.*

@Entity
@Table(name = "script")
data class Script(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "asset_id", insertable = false, updatable = false)
    var assetId: Long,

    @ManyToOne
    @JoinColumn(name = "asset_id")
    var asset: Asset,

    var text: String,
    var isSolution: Boolean,
    var isButton: Boolean,
    var sortOrderSolution: Int,

    @Column(name = "solution_type_id", insertable = false, updatable = false)
    var solutionTypeId: Long,

    @ManyToOne
    @JoinColumn(name = "solution_type_id")
    var solutionType: SolutionType,

    @Column(name = "translation_id", insertable = false, updatable = false)
    var translationId: Long,

    @ManyToOne
    @JoinColumn(name = "translation_id")
    var translation: Translation,

    var sqlRaw: String
)

