package com.mtabak.urlshortener.controller

import com.mtabak.urlshortener.domain.URL
import com.mtabak.urlshortener.domain.URLDto
import com.mtabak.urlshortener.service.URLService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class URLController(private val urlService: URLService) {
    @GetMapping("/{hash}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getOrigin(@PathVariable hash: String): ResponseEntity<String> {
        val headers = HttpHeaders()
        with(urlService) {
            getOrigin(hash)
                .map { origin ->  headers.add("Location", origin.originURL)}
        }

        if (headers.isEmpty()) {
            return ResponseEntity.notFound().build()
        }

        return ResponseEntity(headers, HttpStatus.FOUND)
    }

    @PostMapping("/url", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createShortLink(@RequestBody @Valid body: URLDto): ResponseEntity<URL> {
        val shortURL = urlService.createShortURL(body.url)
        return ResponseEntity(shortURL, HttpStatus.CREATED)
    }
}