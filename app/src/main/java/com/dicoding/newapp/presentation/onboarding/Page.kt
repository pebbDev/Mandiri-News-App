package com.dicoding.newapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.dicoding.newapp.R

data class Page (
    val title : String,
    val description : String,
    @DrawableRes val image : Int
)

val pages = listOf(
    Page(
        title = "Tujuan Rakamin Project-Based Internship",
        description = "Rakamin Project-Based Internship",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Bank Mandiri Mobile Apps Developer",
        description = "Bank Mandiri Mobile Apps Developer",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Livin' by Mandiri",
        description = "Livin' by Mandiri",
        image = R.drawable.onboarding3
    )
)
