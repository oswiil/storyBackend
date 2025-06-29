package org.example.model

import jakarta.persistence.*

@Entity
@Table(name = "translation")
data class Translation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "language_id", insertable = false, updatable = false)
    var languageId: Long,

    @ManyToOne
    @JoinColumn(name = "language_id")
    var language: Language,

    var text: String,

    @OneToMany(mappedBy = "translation")
    var scripts: MutableList<Script> = mutableListOf()
)

