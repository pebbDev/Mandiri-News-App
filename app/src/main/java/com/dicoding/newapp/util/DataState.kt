package com.dicoding.newapp.util

sealed class UIComponent {

    data class Toast(val message: String): UIComponent()

}