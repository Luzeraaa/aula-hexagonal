package com.hexagonal.hexagonal.adapters.out

import com.hexagonal.hexagonal.adapters.out.repository.CustomerRepository
import com.hexagonal.hexagonal.applications.ports.out.DeleteCustomerByIdOutputPort
import org.springframework.stereotype.Component

@Component
class DeleteCustomerByIdAdapter(

    private val customerRepository: CustomerRepository

) : DeleteCustomerByIdOutputPort {

    override fun delete(id: String) {
        customerRepository.deleteById(id)
    }
}