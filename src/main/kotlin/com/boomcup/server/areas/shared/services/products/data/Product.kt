package com.boomcup.server.areas.shared.services.products.data

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "oc_product")
data class Product (

        @Id
        @Column(name = "product_id")
        val id : Long,

        @Column(name = "model")
        val name: String,

        val sku: String,

        val image: String,

        val price: Double,

        val quantity: Int,

        val viewed: Int,

        @Column(name = "date_added", updatable = false)
        @CreatedDate
        val dateAdded: Date,

        @Column(name = "date_modified")
        @LastModifiedDate
        val dateModified: Date
) {

        @JsonManagedReference
        @OneToMany(mappedBy = "product", cascade = [ CascadeType.ALL ])
        var productAttributes: List<ProductAttribute> = ArrayList()
}