package com.hexagonal.hexagonal.config

import com.hexagonal.hexagonal.applications.core.usecase.DeleteCustomerByIdUseCase
import com.hexagonal.hexagonal.applications.ports.`in`.FindCustomerByIdInputPort
import com.hexagonal.hexagonal.applications.ports.out.DeleteCustomerByIdOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerByIdConfig {


    @Bean
    fun deleteById(
        findCustomerByIdInputPort: FindCustomerByIdInputPort,
        deleteCustomerByIdOutputPort: DeleteCustomerByIdOutputPort
    ) = DeleteCustomerByIdUseCase(findCustomerByIdInputPort, deleteCustomerByIdOutputPort)

}