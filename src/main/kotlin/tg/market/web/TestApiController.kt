package tg.market.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tg.market.db.entity.ProductEntity
import tg.market.service.ProductService

@RestController
@RequestMapping("/test")
class TestApiController(
    private val productService: ProductService
) {

    @GetMapping("/products")
    fun allProducts() = productService.findAll()

    @PostMapping("/products")
    fun addProducts(
        @RequestBody
        products: List<ProductEntity>
    ) = productService.saveAll(products)

}