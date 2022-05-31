package com.mtabak.urlshortener.controller

import com.mtabak.urlshortener.domain.URLDto
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class URLControllerIT(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun getOrigin() {
        val entity = restTemplate.getForEntity("/12345678", String::class.java)

        assertTrue(entity.statusCode.is4xxClientError)
    }

    @Test
    fun createShortLink() {

        val entity = restTemplate.postForEntity("/url", URLDto("http://google.com"), String::class.java)

        assertTrue(entity.statusCode.is2xxSuccessful)
    }
}