package com.hexagonal.hexagonal.applications.core.usecase

import com.hexagonal.hexagonal.applications.core.exceptions.ObjectNotFoundException
import com.hexagonal.hexagonal.applications.ports.`in`.FindCustomerByIdInputPort
import com.hexagonal.hexagonal.applications.ports.out.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase(

    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort

) : FindCustomerByIdInputPort {

    override fun findById(id: String) =
        findCustomerByIdOutputPort.find(id) ?: throw ObjectNotFoundException("Customer not found")

}