package com.hexagonal.hexagonal.applications.core.domain

data class Customer(

    val id: String? = null,

    val name: String,

    var address: Address? = null,

    val cpf: String,

    val isValidCpf: Boolean = false

)
