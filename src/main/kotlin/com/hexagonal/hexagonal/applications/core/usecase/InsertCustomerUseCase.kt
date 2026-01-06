package com.hexagonal.hexagonal.applications.core.usecase

import com.hexagonal.hexagonal.applications.core.domain.Customer
import com.hexagonal.hexagonal.applications.ports.out.FindAddressByZipCodeOutputPort
import com.hexagonal.hexagonal.applications.ports.out.InsertCustomerOutputPort

class InsertCustomerUseCase(

    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,

    private val insertCustomerUseCase: InsertCustomerOutputPort

) {

    fun insert(customer: Customer, zipCode: String) {

        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            insertCustomerUseCase.insert(it)
        }


    }
}