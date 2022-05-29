package com.mtabak.urlshortener.domain

import lombok.Builder
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@Builder
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