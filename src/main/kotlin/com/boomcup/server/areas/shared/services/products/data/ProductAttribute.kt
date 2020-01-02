package com.boomcup.server.areas.shared.services.products.data

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "oc_product_attribute")
data class ProductAttribute (

    @JsonIgnore
    @EmbeddedId
    val id: ProductAttributePK,

    @JsonBackReference
    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    val product: Product,

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("attribute_id")
    @JoinColumn(name = "attribute_id")
    val attribute: Attribute,

    val text: String
)

@Embeddable
data class ProductAttributePK (

        @Column(name = "product_id")
        val productId: Long,

        @Column(name = "attribute_id")
        val attributeId: Long

) : Serializable {

    override fun equals(o: Any?): Boolean {

        if (this === o)
            return true

        if (o == null || javaClass != o.javaClass)
            return false

        val that: ProductAttributePK = o as ProductAttributePK

        return Objects.equals(productId, that.productId) &&
                Objects.equals(attributeId, that.attributeId)
    }

    override fun hashCode(): Int {
        return Objects.hash(productId, attributeId)
    }

}