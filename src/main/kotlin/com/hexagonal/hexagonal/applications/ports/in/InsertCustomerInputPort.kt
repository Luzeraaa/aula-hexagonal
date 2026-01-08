package com.hexagonal.hexagonal.applications.ports.`in`

import com.hexagonal.hexagonal.applications.core.domain.Customer

interface InsertCustomerInputPort {

    fun insert(customer: Customer, zipCode: String)

}