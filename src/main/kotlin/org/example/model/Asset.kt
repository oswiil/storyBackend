package org.example.model
import jakarta.persistence.*

@Entity
@Table(name = "asset")
data class Asset(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "coordinates_id")
    var coordinates: Coordinates,

    var imageId: String,
    var audioId: String,

    @ManyToOne
    @JoinColumn(name = "level_id")
    var level: Level,

    @ManyToOne
    @JoinColumn(name = "asset_type_id")
    var assetType: AssetType,

    @OneToMany(mappedBy = "asset")
    var scripts: MutableList<Script> = mutableListOf()
)
