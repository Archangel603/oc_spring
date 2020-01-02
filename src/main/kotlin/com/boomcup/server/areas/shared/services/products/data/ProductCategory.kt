package com.boomcup.server.areas.shared.services.products.data

import javax.persistence.Column
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "oc_product_to_category")
data class ProductCategory(

    @EmbeddedId
    val id: ProductCategoryPK
)