package com.example.applicationschool.Dto

// Kjo klasë përfaqëson një kërkesë për filtrim me një string
// të thjeshtë dhe informacion për pagination (faqeveçim)
data class SimpleStringFilterDto(
    val filter: String?,
    val pagination: PaginationDto?
)

data class PaginationDto(
    val page: Int?,
    val size: Int?
)
