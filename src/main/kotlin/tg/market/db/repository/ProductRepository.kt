package tg.market.db.repository

import org.springframework.data.jpa.repository.JpaRepository
import tg.market.db.entity.ProductEntity

interface ProductRepository : JpaRepository<ProductEntity, Long> {



}