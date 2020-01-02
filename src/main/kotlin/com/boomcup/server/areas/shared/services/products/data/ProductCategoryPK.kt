package com.boomcup.server.areas.shared.services.products.data

import java.io.Serializable
import javax.persistence.*

@Embeddable
data class ProductCategoryPK (

    @Column(name = "product_id")
    val productId: Long,

    @Column(name = "category_id")
    val categoryId: Int

) : Serializable