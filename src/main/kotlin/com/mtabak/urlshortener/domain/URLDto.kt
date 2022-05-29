package com.mtabak.urlshortener.domain

import javax.validation.constraints.NotBlank

class URLDto(
    @NotBlank
    val url: String
)