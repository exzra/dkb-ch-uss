package com.mtabak.urlshortener.service

import com.mtabak.urlshortener.domain.URL
import com.mtabak.urlshortener.repository.URLRepository
import org.springframework.stereotype.Service
import java.security.MessageDigest
import java.time.LocalDateTime
import java.util.*

@Service
class URLService(val repository: URLRepository) {
    fun getOrigin(hash: String): Optional<URL> = repository.findById(hash)

    fun createShortURL(originURL: String): URL {
        return repository.save(
                URL(hashString(originURL).substring(0, 8),
                originURL,
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(30)))
    }

    private fun hashString(input: String): String {
        return MessageDigest
            .getInstance("SHA-256")
            .digest(input.toByteArray())
            .fold("", { str, it -> str + "%02x".format(it) })
    }
}