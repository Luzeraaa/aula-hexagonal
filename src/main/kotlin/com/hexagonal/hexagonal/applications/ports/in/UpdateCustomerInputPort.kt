package com.hexagonal.hexagonal.applications.ports.`in`

import com.hexagonal.hexagonal.applications.core.domain.Customer

interface UpdateCustomerInputPort {

    fun update(customer: Customer, zipCode: String)

}