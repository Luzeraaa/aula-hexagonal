package com.hexagonal.hexagonal.adapters.out

import com.hexagonal.hexagonal.adapters.out.repository.CustomerRepository
import com.hexagonal.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.hexagonal.hexagonal.applications.core.domain.Customer
import com.hexagonal.hexagonal.applications.ports.out.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(

    private val customerRepository: CustomerRepository

) : UpdateCustomerOutputPort {

    override fun update(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }


}