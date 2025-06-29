package org.example.model
import jakarta.persistence.*

@Entity
@Table(name = "asset_type")
data class AssetType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var type: String,

    @OneToMany(mappedBy = "assetType")
    var assets: MutableList<Asset> = mutableListOf()
)
