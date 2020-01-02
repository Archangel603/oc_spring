package com.boomcup.server.areas.shared.services.products

import com.boomcup.server.areas.shared.services.products.dao.IProductsRepository
import com.boomcup.server.areas.shared.services.products.data.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.awt.print.Pageable

@Service
class ProductsService : IProductsService {

    private val PRODUCTS_ON_PAGE = 2

    @Autowired
    private lateinit var _productsRepository : IProductsRepository

    override fun getProductsPage(page: Int): List<Product> {

        val pageable = PageRequest.of(page - 1, PRODUCTS_ON_PAGE, Sort.by("id").ascending())

        val products = _productsRepository.findAll(pageable)

        return products.content
    }

    override fun getCategoryProductsPage(categoryId: Int, page: Int): List<Product> {

        val pageable = PageRequest.of(page - 1, PRODUCTS_ON_PAGE, Sort.by("id").ascending())

        val products = _productsRepository.findAllByCategory(categoryId, pageable)

        return products.content
    }
}