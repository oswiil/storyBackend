package org.example.model


import jakarta.persistence.*

@Entity
@Table(name = "level")
data class Level(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "story_id", insertable = false, updatable = false)
    var storyId: Long,

    @ManyToOne
    @JoinColumn(name = "story_id")
    var story: Story,

    @Column(name = "chapter_id", insertable = false, updatable = false)
    var chapterId: Long,

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    var chapter: Chapter,

    @OneToMany(mappedBy = "level")
    var assets: MutableList<Asset> = mutableListOf(),


)
