package tg.market.db.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "product")
data class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,

    @Column
    var name: String,

    @Column
    var description: String,

    @Column
    var prise: Int,
)