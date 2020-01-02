package com.boomcup.server.areas.shared.services.products

import com.boomcup.server.areas.shared.services.products.data.Product

interface IProductsService {

    fun getProductsPage(page: Int): List<Product>

    fun getCategoryProductsPage(categoryId: Int, page: Int): List<Product>

}