package com.boomcup.server.areas.public.controllers

import com.boomcup.server.areas.shared.services.products.IProductsService
import com.boomcup.server.areas.shared.services.products.dao.IProductsRepository
import com.boomcup.server.areas.shared.services.products.data.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductsController {

    @Autowired
    private lateinit var _productsService : IProductsService;

    @GetMapping(params = [ "page" ])
    fun getPage(@RequestParam page: Int): List<Product> {

        val products = _productsService.getProductsPage(page)

        return products
    }

    @GetMapping(params = [ "page", "category" ])
    fun getPage(@RequestParam page: Int, @RequestParam category: Int): List<Product> {

        val products = _productsService.getCategoryProductsPage(category, page)

        return products
    }

}