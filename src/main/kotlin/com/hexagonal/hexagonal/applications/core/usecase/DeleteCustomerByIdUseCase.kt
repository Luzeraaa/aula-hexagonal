package com.hexagonal.hexagonal.applications.core.usecase

import com.hexagonal.hexagonal.applications.ports.`in`.DeleteCustomerByIdInputPort
import com.hexagonal.hexagonal.applications.ports.`in`.FindCustomerByIdInputPort
import com.hexagonal.hexagonal.applications.ports.out.DeleteCustomerByIdOutputPort

class DeleteCustomerByIdUseCase(

    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,

    private val deleteCustomerByIdOutputPort: DeleteCustomerByIdOutputPort

) : DeleteCustomerByIdInputPort {

    override fun delete(id: String) {

        val customer = findCustomerByIdInputPort.findById(id)
        deleteCustomerByIdOutputPort.delete(id)

    }

}