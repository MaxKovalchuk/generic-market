package tg.market.service

import org.springframework.stereotype.Service
import tg.market.db.entity.ProductEntity
import tg.market.db.repository.ProductRepository

@Service
class ProductService(
    private val repository: ProductRepository
) {

    fun findAll(): List<ProductEntity> = repository.findAll()

    fun saveAll(products: List<ProductEntity>): List<ProductEntity> = repository.saveAll(products)

}