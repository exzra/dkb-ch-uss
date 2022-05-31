package com.mtabak.urlshortener.repository

import com.mtabak.urlshortener.domain.URL
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import java.time.LocalDateTime

@DataJpaTest
@ActiveProfiles("it")
class URLRepositoryIT @Autowired constructor(
    val urlRepository: URLRepository) {

    @Test
    fun saveAndFindById() {
        val url1 = URL("12345678", "http://google.com", LocalDateTime.now(), LocalDateTime.now().plusDays(30))

        val savedUrl = urlRepository.save(url1)

        val foundUrl = urlRepository.findById("12345678")

        assertThat(foundUrl.get()).isEqualTo(savedUrl)
    }

    @Test
    fun findByIdThenNothingFound() {
        val foundUrl = urlRepository.findById("123456ab")

        assertFalse(foundUrl.isPresent)
    }
}