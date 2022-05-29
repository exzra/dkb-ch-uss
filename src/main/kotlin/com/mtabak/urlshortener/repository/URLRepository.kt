package com.mtabak.urlshortener.repository

import com.mtabak.urlshortener.domain.URL
import org.springframework.data.jpa.repository.JpaRepository

interface URLRepository : JpaRepository<URL, String> {
}