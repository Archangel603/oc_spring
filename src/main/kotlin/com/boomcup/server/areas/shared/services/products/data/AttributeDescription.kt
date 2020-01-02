package com.boomcup.server.areas.shared.services.products.data

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "oc_attribute_description")
data class AttributeDescription (

    @JsonIgnore
    @EmbeddedId
    val id: AttributeDescriptionPK,

    @JsonBackReference
    @ManyToOne
    @MapsId("attribute_id")
    @JoinColumn(name = "attribute_id")
    val attribute: Attribute,

    val name: String,

    val icon: String

)

@Embeddable
data class AttributeDescriptionPK (

    @Column(name = "attribute_id")
    val attributeId: Long,

    @Column(name = "language_id")
    val languageId: Int

) : Serializable {

    override fun equals(o: Any?): Boolean {
        if (this === o)
            return true

        if (o == null || javaClass != o.javaClass)
            return false

        val that: AttributeDescriptionPK = o as AttributeDescriptionPK

        return Objects.equals(attributeId, that.attributeId) &&
                Objects.equals(languageId, that.languageId)
    }

    override fun hashCode(): Int {
        return Objects.hash(attributeId, languageId)
    }

}