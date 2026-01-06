package com.hexagonal.hexagonal.applications.ports.out

import com.hexagonal.hexagonal.applications.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun find(zipCode: String): Address
}