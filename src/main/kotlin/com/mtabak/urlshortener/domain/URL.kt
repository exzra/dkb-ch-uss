package com.mtabak.urlshortener.domain

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class URL(
    @Id
    val hash: String?=null,

    @Column(nullable = false)
    val originURL: String,

    @Column(nullable = false)
    val creationDate: LocalDateTime,

    @Column(nullable = false)
    val expirationDate: LocalDateTime
)