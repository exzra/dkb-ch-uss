package com.mtabak.urlshortener.service

import com.mtabak.urlshortener.domain.URL
import com.mtabak.urlshortener.repository.URLRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito
import java.time.LocalDateTime
import java.util.*

class URLServiceTest {
    var urlRepository: URLRepository = Mockito.mock(URLRepository::class.java)

    var urlService = URLService(urlRepository)

    @Test
    fun testLinkCreation() {
        val url = URL("12345678", "http://google.com", LocalDateTime.now(), LocalDateTime.now().plusDays(30))
        Mockito.`when`(urlRepository.save(any())).thenReturn(url)

        val createdShortLink =
            urlService.createShortURL("http://google.com")

        assertEquals("12345678", createdShortLink.hash)
    }

    @Test
    fun testGetOriginUrl() {
        val url = URL("12345678", "http://google.com", LocalDateTime.now(), LocalDateTime.now().plusDays(30))
        Mockito.`when`(urlRepository.findById(any())).thenReturn(Optional.of(url))
        val origin = urlService.getOrigin("12345678")

        assertTrue(origin.isPresent)
        assertEquals("http://google.com", origin.get().originUrl)
    }
}