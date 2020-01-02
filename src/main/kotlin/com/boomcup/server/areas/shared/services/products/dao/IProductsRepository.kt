package com.boomcup.server.areas.shared.services.products.dao

import com.boomcup.server.areas.shared.services.products.data.Product
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.data.domain.Pageable

@Repository
interface IProductsRepository : JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p JOIN ProductCategory pc ON pc.id.categoryId = :cat_id")
    fun findAllByCategory(@Param("cat_id") category: Int, pageable: Pageable): Page<Product>

    @Query("""
        SELECT p FROM Product p 
            JOIN ProductCategory pc ON pc.id.categoryId = :cat_id
    """)
    fun findAllByCategoryWithAttributes(@Param("cat_id") category: Int, pageable: Pageable): Page<Product>

}