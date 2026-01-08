package com.hexagonal.hexagonal.applications.ports.out

import com.hexagonal.hexagonal.applications.core.domain.Customer

interface UpdateCustomerOutputPort {

    fun update(customer: Customer)

}