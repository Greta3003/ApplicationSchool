package com.example.applicationschool.Api
//lasë e mbyllur (sealed) që përfaqëson statusin e një operacioni të të dhënave (API, db)

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()//tregon sukses
    data class Error(val message: String?) : Resource<Nothing>()// tregon error
    object Loading : Resource<Nothing>()// tregon ngarkim
}