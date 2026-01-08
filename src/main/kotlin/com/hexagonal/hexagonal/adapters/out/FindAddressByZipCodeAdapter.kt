package com.hexagonal.hexagonal.adapters.out

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.hexagonal.hexagonal.adapters.out.client.AddressClient
import com.hexagonal.hexagonal.applications.core.domain.Address
import com.hexagonal.hexagonal.applications.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(

    private val addressClient: AddressClient

) : FindAddressByZipCodeOutputPort {

    override fun find(zipCode: String): Address {

        val objectMapper = ObjectMapper().registerKotlinModule()

        return objectMapper.convertValue(addressClient.find(zipCode), Address::class.java)

    }


}