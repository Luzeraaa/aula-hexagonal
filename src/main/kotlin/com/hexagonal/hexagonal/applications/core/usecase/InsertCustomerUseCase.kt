package com.hexagonal.hexagonal.applications.core.usecase

import com.hexagonal.hexagonal.applications.core.domain.Customer
import com.hexagonal.hexagonal.applications.ports.`in`.InsertCustomerInputPort
import com.hexagonal.hexagonal.applications.ports.out.FindAddressByZipCodeOutputPort
import com.hexagonal.hexagonal.applications.ports.out.InsertCustomerOutputPort
import com.hexagonal.hexagonal.applications.ports.out.SendCpfForValidationOutputPort

class InsertCustomerUseCase(

    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,

    private val insertCustomerUseCase: InsertCustomerOutputPort,

    private val cpfForValidationOutputPort: SendCpfForValidationOutputPort

) : InsertCustomerInputPort {

    override fun insert(customer: Customer, zipCode: String) {

        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            cpfForValidationOutputPort.send(it.cpf)
            insertCustomerUseCase.insert(it)
        }


    }
}