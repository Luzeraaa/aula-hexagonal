package com.hexagonal.hexagonal.adapters.out.client

import com.hexagonal.hexagonal.adapters.out.client.response.AddressResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@FeignClient(
    name = "AddressClient",
    url =  "\${address.url}"
)
interface AddressClient {

    @GetMapping("/{zipCode}")
    fun find(@PathVariable zipCode: String): AddressResponse

}