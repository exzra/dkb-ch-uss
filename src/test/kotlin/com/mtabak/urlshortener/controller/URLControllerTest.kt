package com.mtabak.urlshortener.controller

import com.mtabak.urlshortener.domain.URL
import com.mtabak.urlshortener.domain.URLDto
import com.mtabak.urlshortener.service.URLService
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.http.HttpStatus
import java.time.LocalDateTime
import java.util.*


class URLControllerTest {
    var urlService: URLService = Mockito.mock(URLService::class.java)

    var urlController = URLController(urlService)

    @Test
    fun testLinkCreation() {
        val url = URL("12345678", "http://google.com", LocalDateTime.now(), LocalDateTime.now().plusDays(30))
        Mockito.`when`(urlService.createShortURL(Mockito.anyString())).thenReturn(url)

        val response =
            urlController.createShortLink(
                URLDto("http://google.com"))

        Assertions.assertEquals(HttpStatus.CREATED, response.statusCode)
        Assertions.assertEquals(url, response.body)
    }

    @Test
    fun testGetOriginUrl() {
        val url = URL("12345678", "http://google.com", LocalDateTime.now(), LocalDateTime.now().plusDays(30))
        Mockito.`when`(urlService.getOrigin(Mockito.anyString())).thenReturn(Optional.of(url))

        val response = urlController.getOrigin("12345678")

        Assertions.assertEquals(HttpStatus.FOUND, response.statusCode)
        assertThat(response.headers.location.toString(), Matchers.`is`("http://google.com"))
    }
}