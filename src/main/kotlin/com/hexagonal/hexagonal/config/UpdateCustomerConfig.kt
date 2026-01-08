package com.hexagonal.hexagonal.config

import com.hexagonal.hexagonal.applications.core.usecase.UpdateCustomerUseCase
import com.hexagonal.hexagonal.applications.ports.`in`.FindCustomerByIdInputPort
import com.hexagonal.hexagonal.applications.ports.out.FindAddressByZipCodeOutputPort
import com.hexagonal.hexagonal.applications.ports.out.UpdateCustomerOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {


    @Bean
    fun updateCustomer(
        findCustomerByIdInputPort: FindCustomerByIdInputPort,

        findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,

        updateCustomerOutputPort: UpdateCustomerOutputPort
    ) = UpdateCustomerUseCase(findCustomerByIdInputPort, findAddressByZipCodeOutputPort, updateCustomerOutputPort)

}