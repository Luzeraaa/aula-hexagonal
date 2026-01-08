package com.hexagonal.hexagonal.adapters.out.repository.entity

import com.hexagonal.hexagonal.applications.core.domain.Address
import com.hexagonal.hexagonal.applications.core.domain.Customer
import org.springframework.data.mongodb.core.mapping.Document

@Document("addresses")
data class AddressEntity(
    val street: String,

    val city: String,

    val state: String
) {

    constructor(address: Address) : this(
        address.street,
        address.city,
        address.state
    )

    fun toAddress() = Address(street, city, state)

}
