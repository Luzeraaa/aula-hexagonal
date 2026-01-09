package com.hexagonal.hexagonal.applications.core.usecase

import com.hexagonal.hexagonal.applications.core.domain.Customer
import com.hexagonal.hexagonal.applications.ports.`in`.FindCustomerByIdInputPort
import com.hexagonal.hexagonal.applications.ports.`in`.UpdateCustomerInputPort
import com.hexagonal.hexagonal.applications.ports.out.FindAddressByZipCodeOutputPort
import com.hexagonal.hexagonal.applications.ports.out.SendCpfForValidationOutputPort
import com.hexagonal.hexagonal.applications.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase(

    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,

    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,

    private val updateCustomerOutputPort: UpdateCustomerOutputPort,

    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort

) : UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String) {

        if (customer.id == null) {
            throw IllegalArgumentException("The id field can't be null")
        }

        val savedCpf = findCustomerByIdInputPort.findById(customer.id).cpf

        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            if (savedCpf != it.cpf) {
                sendCpfForValidationOutputPort.send(it.cpf)
            } else {
                updateCustomerOutputPort.update(customer)
            }

        }

    }

}