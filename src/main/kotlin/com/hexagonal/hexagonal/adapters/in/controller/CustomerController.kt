package com.hexagonal.hexagonal.adapters.`in`.controller

import com.hexagonal.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.hexagonal.hexagonal.adapters.`in`.controller.response.CustomerResponse
import com.hexagonal.hexagonal.applications.core.domain.Customer
import com.hexagonal.hexagonal.applications.ports.`in`.FindCustomerByIdInputPort
import com.hexagonal.hexagonal.applications.ports.`in`.InsertCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(

    private val insertCustomerInputPort: InsertCustomerInputPort,

    private val findCustomerByIdInputPort: FindCustomerByIdInputPort

) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insertCustomer(@Valid @RequestBody customerRequest: CustomerRequest) {

        with(customerRequest) {
            val customer = Customer(name = name, cpf = cpf)
            insertCustomerInputPort.insert(customer, customerRequest.zipCode)
        }


    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String): ResponseEntity<CustomerResponse> {

        val customer = CustomerResponse(findCustomerByIdInputPort.findById(id))
        return ResponseEntity.ok().body(customer)

    }

}