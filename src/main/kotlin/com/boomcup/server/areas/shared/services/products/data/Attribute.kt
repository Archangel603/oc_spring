package com.boomcup.server.areas.shared.services.products.data

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "oc_attribute")
data class Attribute (

    @Id
    @Column(name = "attribute_id")
    val id: Long

) {

    @JsonBackReference
    @OneToMany(mappedBy = "attribute", cascade = [ CascadeType.ALL ])
    val productAttributes: List<ProductAttribute> = ArrayList()

    @JsonManagedReference
    @OneToMany(mappedBy = "attribute", cascade = [ CascadeType.ALL ])
    val descriptions: List<AttributeDescription> = ArrayList()

}