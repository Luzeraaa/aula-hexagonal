package com.hexagonal.hexagonal.adapters.out

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.hexagonal.hexagonal.applications.core.domain.Address
import com.hexagonal.hexagonal.applications.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(

    private val findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter

) : FindAddressByZipCodeOutputPort {

    override fun find(zipCode: String): Address {

        val objectMapper = ObjectMapper().registerKotlinModule()

        return objectMapper.convertValue(findAddressByZipCodeAdapter.find(zipCode), Address::class.java)

    }


}