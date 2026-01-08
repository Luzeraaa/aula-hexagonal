package com.hexagonal.hexagonal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class HexagonalApplication

fun main(args: Array<String>) {
    runApplication<HexagonalApplication>(*args)
}
