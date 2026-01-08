package com.hexagonal.hexagonal.applications.core.usecase

import com.hexagonal.hexagonal.applications.core.domain.Customer
import com.hexagonal.hexagonal.applications.ports.`in`.FindCustomerByIdInputPort
import com.hexagonal.hexagonal.applications.ports.`in`.UpdateCustomerInputPort
import com.hexagonal.hexagonal.applications.ports.out.FindAddressByZipCodeOutputPort
import com.hexagonal.hexagonal.applications.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase(

    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,

    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,

    private val updateCustomerOutputPort: UpdateCustomerOutputPort

) : UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String) {

        if (customer.id == null) {
            throw IllegalArgumentException("The id field can't be null")
        }

        findCustomerByIdInputPort.findById(customer.id)

        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            updateCustomerOutputPort.update(customer)
        }

    }

}