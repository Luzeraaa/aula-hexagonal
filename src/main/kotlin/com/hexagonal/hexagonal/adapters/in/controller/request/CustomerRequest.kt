package com.hexagonal.hexagonal.adapters.`in`.controller.request

import jakarta.validation.constraints.NotBlank

data class CustomerRequest(

    @field:NotBlank(message = "name not be null")
    val name: String,

    @field:NotBlank(message = "cpf not be null")
    val cpf: String,

    @field:NotBlank(message = "zipCode not be null")
    val zipCode: String

)
