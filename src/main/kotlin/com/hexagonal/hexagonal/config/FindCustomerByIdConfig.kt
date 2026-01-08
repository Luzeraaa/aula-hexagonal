package com.hexagonal.hexagonal.config

import com.hexagonal.hexagonal.applications.core.usecase.FindCustomerByIdUseCase
import com.hexagonal.hexagonal.applications.ports.out.FindCustomerByIdOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {

    @Bean
    fun findById(
        findCustomerByIdOutputPort: FindCustomerByIdOutputPort
    ) = FindCustomerByIdUseCase(findCustomerByIdOutputPort)
}