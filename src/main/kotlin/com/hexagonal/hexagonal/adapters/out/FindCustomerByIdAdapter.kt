package com.hexagonal.hexagonal.adapters.out

import com.hexagonal.hexagonal.adapters.out.repository.CustomerRepository
import com.hexagonal.hexagonal.applications.core.domain.Customer
import com.hexagonal.hexagonal.applications.ports.out.FindCustomerByIdOutputPort
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
) : FindCustomerByIdOutputPort {

    override fun find(id: String): Customer? =
        customerRepository.findById(id)
            .getOrNull()
            .let {
                return it?.toCustomer()
            }
}