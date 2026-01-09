package com.hexagonal.hexagonal.applications.ports.out

interface SendCpfForValidationOutputPort {

    fun send(cpf: String)
}