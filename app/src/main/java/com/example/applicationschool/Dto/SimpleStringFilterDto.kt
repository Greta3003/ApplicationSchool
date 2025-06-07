package com.example.applicationschool.Dto


data class SimpleStringFilterDto(
    val filter: String?,
    val pagination: PaginationDto?
)

data class PaginationDto(
    val page: Int?,
    val size: Int?
)
