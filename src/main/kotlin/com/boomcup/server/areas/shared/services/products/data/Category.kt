package com.boomcup.server.areas.shared.services.products.data

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "oc_category")
data class Category (

    @Id
    @Column(name = "category_id")
    val id: Int,

    val image: String
)