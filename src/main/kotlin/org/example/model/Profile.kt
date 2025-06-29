package org.example.model


import jakarta.persistence.*

@Entity
@Table(name = "profile")
data class Profile(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var plan: String
) {
    @OneToMany(mappedBy = "profile")
    var users: MutableSet<User> = HashSet()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as Profile
        return id != null && id == that.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}