package org.example.model
import jakarta.persistence.*

@Entity
@Table(name = "chapter")
data class Chapter(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var title: String,
    var solution: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_id", nullable = false)
    var story: Story,

    var number: Int,

    @OneToMany(mappedBy = "chapter")
    var solutions: MutableList<Solution> = mutableListOf()
)
