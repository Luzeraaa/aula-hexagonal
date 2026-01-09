package com.hexagonal.hexagonal.config

import com.hexagonal.hexagonal.applications.core.usecase.InsertCustomerUseCase
import com.hexagonal.hexagonal.applications.ports.out.FindAddressByZipCodeOutputPort
import com.hexagonal.hexagonal.applications.ports.out.InsertCustomerOutputPort
import com.hexagonal.hexagonal.applications.ports.out.SendCpfForValidationOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomer(

        findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,

        insertCustomerUseCase: InsertCustomerOutputPort,

        sendCpfForValidationOutputPort: SendCpfForValidationOutputPort

    ) = InsertCustomerUseCase(findAddressByZipCodeOutputPort, insertCustomerUseCase, sendCpfForValidationOutputPort)

}