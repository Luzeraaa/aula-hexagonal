package com.hexagonal.hexagonal.applications.ports.out

import com.hexagonal.hexagonal.applications.core.domain.Customer

interface InsertCustomerOutputPort {

    fun insert(customer: Customer)

}