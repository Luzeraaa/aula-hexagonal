package com.hexagonal.hexagonal.adapters.out

import com.hexagonal.hexagonal.adapters.out.repository.CustomerRepository
import com.hexagonal.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.hexagonal.hexagonal.applications.core.domain.Customer
import com.hexagonal.hexagonal.applications.ports.out.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(

    private val customerRepository: CustomerRepository

) : InsertCustomerOutputPort{

    override fun insert(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }

}