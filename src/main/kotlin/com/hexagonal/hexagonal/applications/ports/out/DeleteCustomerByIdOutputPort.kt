package com.hexagonal.hexagonal.applications.ports.out

interface DeleteCustomerByIdOutputPort {

    fun delete(id: String)

}