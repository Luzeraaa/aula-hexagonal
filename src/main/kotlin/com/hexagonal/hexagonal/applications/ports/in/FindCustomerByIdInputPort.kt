package com.hexagonal.hexagonal.applications.ports.`in`

import com.hexagonal.hexagonal.applications.core.domain.Customer

interface FindCustomerByIdInputPort {

    fun findById(id: String): Customer
}